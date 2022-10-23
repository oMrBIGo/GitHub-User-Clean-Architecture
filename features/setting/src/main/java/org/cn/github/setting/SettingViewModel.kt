package org.cn.github.setting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.cn.github.common.ui.base.BaseViewModel
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.UserList
import org.cn.github.search.SearchFragmentDirections

class SettingViewModel: BaseViewModel() {

    val displayHome: () -> Unit = {
        navigate(
            NavigationCommand.To(
                SettingFragmentDirections.actionSettingFragmentToNavHome()
            )
        )
    }

    val displaySearch: ()-> Unit = {
        navigate(
            NavigationCommand.To(
                SettingFragmentDirections.actionSettingFragmentToNavSearch()
            )
        )
    }

}