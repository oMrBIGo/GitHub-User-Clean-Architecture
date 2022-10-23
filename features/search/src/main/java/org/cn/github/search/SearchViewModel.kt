package org.cn.github.search

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.cn.github.common.ui.base.BaseViewModel
import org.cn.github.common.ui.util.SingleLiveEvent
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.UserList
import org.cn.github.domain.usecase.SearchUseCase
import org.cn.github.home.HomeFragmentDirections

class SearchViewModel(
    private val searchUseCase: SearchUseCase,
) : BaseViewModel() {

    var userListResult = MutableLiveData<ArrayList<UserList>>()
    var isSearch = MutableLiveData<Boolean>(false)
    var keyword = SingleLiveEvent<String>()
    val filter = MutableLiveData<String>()
    val isEmptyItem = MutableLiveData<Boolean>()

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        isSearch.value = s.isNotBlank()
        val timer = object : CountDownTimer(50, 50) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                if (s.isNotBlank() && keyword.value != s.toString()) {
                    keyword.value = s.toString()
                }
            }
        }
        timer.start()
    }

    fun getUsersList() {
        progressDialogEvent.value = true
        viewModelScope.launch {
            when (val result = searchUseCase.getUserList()) {
                is NetworkResponse.Success -> {
                    userListResult.value = result.body
                    updateItem()
                }
                is NetworkResponse.ApiError -> {
                    handlerError(result.body)
                }
                is NetworkResponse.NetworkError -> {
                    createOneButtonDialogEvent(messageRes = R.string.Error_Network_title)
                }
                is NetworkResponse.UnknownError -> {
                    createAlertDialogEvent()
                }
                else -> {}
            }
            progressDialogEvent.value = false
        }
    }

    private fun updateItem() {
        isEmptyItem.value = userListResult.value?.isNullOrEmpty()
    }

    val displayHome: () -> Unit = {
        navigate(
            NavigationCommand.To(
                SearchFragmentDirections.actionSearchFragmentToNavHome()
            )
        )
    }

    val displaySetting: () -> Unit = {
        navigate(
            NavigationCommand.To(
                SearchFragmentDirections.actionSearchFragmentToNavSetting()
            )
        )
    }

    fun displayUserInfo(login: String, avatarUrl: String) {
        navigate(
            NavigationCommand.To(
                SearchFragmentDirections.actionSearchFragmentToNavUserinfo(login, avatarUrl)
            )
        )
    }
}