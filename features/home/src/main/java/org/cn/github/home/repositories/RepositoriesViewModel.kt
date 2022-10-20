package org.cn.github.home.repositories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.cn.github.common.ui.base.BaseViewModel
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.RepoList
import org.cn.github.domain.usecase.HomeUseCase
import org.cn.github.home.R

class RepositoriesViewModel(
    private val homeUseCase: HomeUseCase
) : BaseViewModel() {

    var login = MutableLiveData<String>()
    var repoListResult = MutableLiveData<ArrayList<RepoList>>()

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
}