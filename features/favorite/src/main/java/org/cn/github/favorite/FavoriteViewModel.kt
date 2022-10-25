package org.cn.github.favorite

import org.cn.github.common.ui.base.BaseViewModel

class FavoriteViewModel : BaseViewModel() {

    val displayHome: () -> Unit = {
        navigate(
            NavigationCommand.To(
                FavoriteFragmentDirections.actionFavoriteFragmentToNavHome()
            )
        )
    }

    val displaySearch: () -> Unit = {
        navigate(
            NavigationCommand.To(
                FavoriteFragmentDirections.actionFavoriteFragmentToNavSearch()
            )
        )
    }

    val displaySetting: () -> Unit = {
        navigate(
            NavigationCommand.To(
                FavoriteFragmentDirections.actionFavoriteFragmentToNavSetting()
            )
        )
    }
}