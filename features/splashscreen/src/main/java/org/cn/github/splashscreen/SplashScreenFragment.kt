package org.cn.github.splashscreen

import org.cn.github.common.ui.base.BaseFragment
import org.cn.github.splashscreen.databinding.FragmentSplashscreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreenFragment : BaseFragment<SplashScreenViewModel, FragmentSplashscreenBinding>() {

    override val viewModel: SplashScreenViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_splashscreen
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
        onBackPress()
    }

    override fun initViewModel() {
        viewModel.checkDefault()
        viewModel.displayHome()
    }
}