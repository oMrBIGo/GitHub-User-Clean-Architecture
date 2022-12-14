package org.cn.github.setting

import NavigationCommand
import org.cn.github.common.ui.base.BaseViewModel

class SettingViewModel : BaseViewModel() {

    val displayHome: () -> Unit = {
        navigate(
            NavigationCommand.To(
                SettingFragmentDirections.actionSettingFragmentToNavHome()
            )
        )
    }

    val displaySearch: () -> Unit = {
        navigate(
            NavigationCommand.To(
                SettingFragmentDirections.actionSettingFragmentToNavSearch()
            )
        )
    }

}