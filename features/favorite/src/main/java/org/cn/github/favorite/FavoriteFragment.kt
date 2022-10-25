package org.cn.github.favorite

import org.cn.github.common.ui.base.BaseFragment
import org.cn.github.favorite.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FavoriteViewModel, FragmentFavoriteBinding>() {

    override val viewModel: FavoriteViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_favorite
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {

    }

    override fun initViewModel() {

    }
}