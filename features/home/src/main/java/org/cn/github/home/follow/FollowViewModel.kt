package org.cn.github.home.follow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.cn.github.common.ui.base.BaseViewModel
import org.cn.github.domain.model.FollowersList
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.UserList
import org.cn.github.domain.usecase.HomeUseCase
import org.cn.github.home.HomeFragmentDirections
import org.cn.github.home.R

class FollowViewModel(
    private val homeUseCase: HomeUseCase
) : BaseViewModel() {

    var login = MutableLiveData<String>()
    var followListResult = MutableLiveData<ArrayList<FollowersList>>()

    fun getFollowList() {
        progressDialogEvent.value = true
        viewModelScope.launch {
            when (val result = homeUseCase.getFollowList(login.value)) {
                is NetworkResponse.Success -> {
                    followListResult.value = result.body
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

    fun displayUserInfo(login: String, avatarUrl: String) {
        navigate(
            NavigationCommand.To(
                FollowFragmentDirections.actionFollowFragmentToNavUserinfo(login, avatarUrl)
            )
        )
    }
}