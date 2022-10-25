package org.cn.github.home

import NavigationCommand
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.cn.github.common.ui.base.BaseViewModel
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.UserList
import org.cn.github.domain.usecase.HomeUseCase
import org.cn.github.domain.usecase.SecurePreferencesUseCase
import org.cn.github.domain.utils.BuildConfigManager

class HomeViewModel(
    private val homeUseCase: HomeUseCase,
    private val securePreferencesUseCase: SecurePreferencesUseCase,
    private val buildConfigManager: BuildConfigManager
) : BaseViewModel() {

    var userListResult = MutableLiveData<ArrayList<UserList>>()

    var language = MutableLiveData<String>(
        securePreferencesUseCase.getStringSharedPreference(
            securePreferencesUseCase.getKeyLanguage()
        )
    )

    fun setLanguage(id: String) {
        language.value = id
        securePreferencesUseCase.commitStringSharedPreference(
            securePreferencesUseCase.getKeyLanguage(),
            id
        )
    }

    fun getUsersList() {
        progressDialogEvent.value = true
        viewModelScope.launch {
            when (val result = homeUseCase.getUserList()) {
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

    fun displayUserMore() {
        navigate(
            NavigationCommand.To(
                HomeFragmentDirections.actionHomeFragmentToNavUserMore()
            )
        )
    }

    fun displayUserInfo(login: String, avatarUrl: String) {
        navigate(
            NavigationCommand.To(
                HomeFragmentDirections.actionHomeFragmentToNavUserinfo(login, avatarUrl)
            )
        )
    }

    fun displaySearch() {
        navigate(
            NavigationCommand.To(
                HomeFragmentDirections.actionHomeFragmentToNavSearch1()
            )
        )
    }

    val displayFavorite: () -> Unit = {
        navigate(
            NavigationCommand.To(
                HomeFragmentDirections.actionHomeFragmentToNavFavorite()
            )
        )
    }

    val displaySearch: () -> Unit = {
        navigate(
            NavigationCommand.To(
                HomeFragmentDirections.actionHomeFragmentToNavSearch()
            )
        )
    }

    val displaySetting: () -> Unit = {
        navigate(
            NavigationCommand.To(
                HomeFragmentDirections.actionHomeFragmentToNavSetting()
            )
        )
    }
}