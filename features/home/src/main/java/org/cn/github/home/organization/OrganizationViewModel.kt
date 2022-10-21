package org.cn.github.home.organization

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.cn.github.common.ui.base.BaseViewModel
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.OrganizationList
import org.cn.github.domain.usecase.HomeUseCase
import org.cn.github.home.R

class OrganizationViewModel(
    private val homeUseCase: HomeUseCase
): BaseViewModel() {

    val login = MutableLiveData<String>()
    val organizationResult = MutableLiveData<ArrayList<OrganizationList>>()

    fun getOrganizationList() {
        progressDialogEvent.value = true
        viewModelScope.launch {
            when (val result = homeUseCase.getOrganizationList(login.value)) {
                is NetworkResponse.Success -> {
                    organizationResult.value = result.body
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