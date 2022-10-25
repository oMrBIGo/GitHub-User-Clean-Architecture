package org.cn.github.home.userInfo

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import org.cn.github.common.ui.base.BaseFragment
import org.cn.github.domain.model.RepoList
import org.cn.github.home.BR
import org.cn.github.home.R
import org.cn.github.home.adapter.PinnedRepoListAdapter
import org.cn.github.home.databinding.FragmentUserinfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserInfoFragment: BaseFragment<UserInfoViewModel, FragmentUserinfoBinding>() {

    private val args: UserInfoFragmentArgs by navArgs()
    private val login by lazy { args.login }
    private val avatar by lazy { args.avatarUrl }

    override val viewModel: UserInfoViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_userinfo
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    private var adapter: PinnedRepoListAdapter? = null

    override fun initView() {
        initToolbar()
    }

    private fun initToolbar() {
        viewModel.initToolbar(title = "")
        binding.toolbarUserInfo.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initViewModel() {
        viewModel.login.value = login
        viewModel.getUserInfo()
        viewModel.getRepoList()
        viewModel.getOrganizationList()
        viewModel.repoListResult.observe(
            this
        ) {
            setPinnedRepoAdapter(it)
        }
    }

    private fun setPinnedRepoAdapter(data: ArrayList<RepoList>) {
        adapter = PinnedRepoListAdapter(
            requireContext(),
            data,
            avatar,
            login
        )
        val lm = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rcvPinnedUserInfo.layoutManager = lm
        binding.rcvPinnedUserInfo.adapter = adapter
    }
}