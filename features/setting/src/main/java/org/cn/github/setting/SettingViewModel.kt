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

    val displayFavorite: () -> Unit = {
        navigate(
            NavigationCommand.To(
                SettingFragmentDirections.actionSettingFragmentToNavFavorite()
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