package org.cn.github.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.cn.github.common.ui.base.BaseViewModel
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.UserList
import org.cn.github.domain.usecase.SearchUseCase

class SearchViewModel(
    private val searchUseCase: SearchUseCase
) : BaseViewModel() {

    var userListResult = MutableLiveData<ArrayList<UserList>>()

    fun getUsersList() {
        progressDialogEvent.value = true
        viewModelScope.launch {
            when(val result = searchUseCase.getUserList()) {
                is NetworkResponse.Success -> {
                    userListResult.value = result.body
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

    val displayHome: () -> Unit = {
        navigate(
            NavigationCommand.To(
                SearchFragmentDirections.actionSearchFragmentToNavHome()
            )
        )
    }

    val displaySetting: ()-> Unit = {
        navigate(
            NavigationCommand.To(
                SearchFragmentDirections.actionSearchFragmentToNavSetting()
            )
        )
    }
}