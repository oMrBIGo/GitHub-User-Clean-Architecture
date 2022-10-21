package org.cn.github.home.userInfo

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.cn.github.common.ui.base.BaseViewModel
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.OrganizationList
import org.cn.github.domain.model.RepoList
import org.cn.github.domain.model.UserInfo
import org.cn.github.domain.usecase.HomeUseCase
import org.cn.github.home.R

class UserInfoViewModel(
    private val homeUseCase: HomeUseCase,
) : BaseViewModel() {

    val login = MutableLiveData<String>()
    val userInfoResult = MutableLiveData<UserInfo>()
    val repoListResult = MutableLiveData<ArrayList<RepoList>>()
    val organizationCount = MutableLiveData<Int>()

    fun getUserInfo() {
        progressDialogEvent.value = true
        viewModelScope.launch {
            when (val result = homeUseCase.getUserInfo(login.value)) {
                is NetworkResponse.Success -> {
                    userInfoResult.value = result.body
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

    fun getRepoList() {
        progressDialogEvent.value = true
        viewModelScope.launch {
            when (val result = homeUseCase.getRepoList(login.value)) {
                is NetworkResponse.Success -> {
                    repoListResult.value = result.body
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

    fun getOrganizationList() {
        progressDialogEvent.value = true
        viewModelScope.launch {
            when (val result = homeUseCase.getOrganizationList(login.value)) {
                is NetworkResponse.Success -> {
                    organizationCount.value = result.body.count()
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

    fun displayRepositories(login: String) {
        navigate(
            NavigationCommand.To(
                UserInfoFragmentDirections.actionUserinfoFragmentToNavRepositories(login)
            )
        )
    }

    fun displayFollow(login: String) {
        navigate(
            NavigationCommand.To(
                UserInfoFragmentDirections.actionUserinfoFragmentToNavFollow(login)
            )
        )
    }

    fun displayOrganization(login: String) {
        navigate(
            NavigationCommand.To(
                UserInfoFragmentDirections.actionUserinfoFragmentToNavOrganization(login)
            )
        )
    }

    fun openWeb(url: String, context: Context) {
        if (!url.isNullOrEmpty()) {
            val builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
            val customTabsIntent: CustomTabsIntent = builder.build()
            customTabsIntent.launchUrl(context, Uri.parse(url))
        }
    }

    fun openTwitter(url: String, context: Context) {
        if (!url.isNullOrEmpty()) {
            val builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
            val customTabsIntent: CustomTabsIntent = builder.build()
            customTabsIntent.launchUrl(context, Uri.parse("https://twitter.com/$url"))
        }
    }

    fun openShare(url: String, context: Context) {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, url)
        context.startActivity(Intent.createChooser(shareIntent, "Share github"))
    }
}