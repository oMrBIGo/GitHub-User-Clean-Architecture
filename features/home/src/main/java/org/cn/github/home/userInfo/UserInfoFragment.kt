package org.cn.github.home.userInfo

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.cn.github.common.ui.base.BaseFragment
import org.cn.github.home.BR
import org.cn.github.home.R
import org.cn.github.home.databinding.FragmentUserinfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserInfoFragment: BaseFragment<UserInfoViewModel, FragmentUserinfoBinding>() {

    private val args: UserInfoFragmentArgs by navArgs()
    private val login by lazy { args.login }

    override val viewModel: UserInfoViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_userinfo
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
        initToolbar()
    }

    private fun initToolbar() {
        viewModel.initToolbar(title = "")
        binding.toolbarUserInfo.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.imvShared.setOnClickListener {

        }
    }

    override fun initViewModel() {
        viewModel.login.value = login
        viewModel.getUserInfo()
    }
}