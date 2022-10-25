package org.cn.github.setting

import org.cn.github.common.ui.base.BaseFragment
import org.cn.github.setting.databinding.FragmentSettingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingFragment : BaseFragment<SettingViewModel, FragmentSettingBinding>() {

    override val viewModel: SettingViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_setting
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
        initToolbar()
        onBackPress()
    }

    private fun initToolbar() {
        viewModel.initToolbar(titleRes = R.string.setting_title)
    }

    override fun initViewModel() {

    }

}