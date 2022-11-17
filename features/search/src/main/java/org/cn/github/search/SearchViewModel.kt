package org.cn.github.search

import NavigationCommand
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.cn.github.common.ui.base.BaseViewModel
import org.cn.github.common.ui.util.SingleLiveEvent
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.SearchUserList
import org.cn.github.domain.usecase.SearchUseCase

class SearchViewModel(
    private val searchUseCase: SearchUseCase,
) : BaseViewModel() {

    var searchListResult = MutableLiveData<ArrayList<SearchUserList.Item>>()
    var isSearch = MutableLiveData<Boolean>(false)
    var keyword = SingleLiveEvent<String>()
    val isEmptyItem = MutableLiveData<Boolean>()

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        isSearch.value = s.isNotBlank()
        if (s.isNotBlank() && keyword.value != s.toString()) {
            keyword.value = s.toString()
        }
    }

    fun getSearchList(keyword: String?) {
        progressDialogEvent.value = true
        viewModelScope.launch {
            when (val result = searchUseCase.getSearchUser(keyword)) {
                is NetworkResponse.Success -> {
                    searchListResult.value = result.body
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
        isEmptyItem.value = searchListResult.value?.isNullOrEmpty()
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