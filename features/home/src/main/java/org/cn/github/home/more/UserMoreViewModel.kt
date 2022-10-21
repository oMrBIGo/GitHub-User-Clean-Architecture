package org.cn.github.home.more

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.cn.github.common.ui.base.BaseViewModel
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.UserList
import org.cn.github.domain.usecase.HomeUseCase
import org.cn.github.home.HomeFragmentDirections
import org.cn.github.home.R

class UserMoreViewModel(
    private val homeUseCase: HomeUseCase
) : BaseViewModel() {

    var userAllListResult = MutableLiveData<ArrayList<UserList>>()

    fun getUsersList() {
        progressDialogEvent.value = true
        viewModelScope.launch {
            when (val result = homeUseCase.getUserList()) {
                is NetworkResponse.Success -> {
                    userAllListResult.value = result.body
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

    fun displayUserInfo(login: String, avatar: String) {
        navigate(
            NavigationCommand.To(
                UserMoreFragmentDirections.actionUserMoreFragmentToNavUserinfo(login, avatar)
            )
        )
    }
}