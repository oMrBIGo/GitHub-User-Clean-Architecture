package org.cn.github.home.follow

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import org.cn.github.common.ui.base.BaseFragment
import org.cn.github.domain.model.FollowersList
import org.cn.github.domain.model.UserList
import org.cn.github.home.BR
import org.cn.github.home.R
import org.cn.github.home.adapter.FollowListAdapter
import org.cn.github.home.databinding.FragmentFollowBinding
import org.cn.github.home.repositories.RepositoriesFragmentArgs
import org.koin.androidx.viewmodel.ext.android.viewModel

class FollowFragment : BaseFragment<FollowViewModel, FragmentFollowBinding>() {

    private val args: FollowFragmentArgs by navArgs()
    private val login by lazy { args.login }

    override val viewModel: FollowViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_follow
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    private var adapter: FollowListAdapter? = null

    override fun initView() {
        initToolbar()
    }

    private fun initToolbar() {
        viewModel.initToolbar(title = "")
        binding.toolbarFollow.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initViewModel() {
        viewModel.login.value = login
        viewModel.getFollowList()
        viewModel.followListResult.observe(
            this
        ) {
            setFollowAdapter(it)
        }
    }

    private fun setFollowAdapter(data: ArrayList<FollowersList>) {
        adapter = FollowListAdapter(
            requireContext(),
            data,
            object : FollowListAdapter.OnItemFollowersClickListener {
                override fun onItemClickListener(login: String, avatarUrl: String) {
                    viewModel.displayUserInfo(login, avatarUrl)
                }
            }
        )
        val lm = LinearLayoutManager(requireContext())
        binding.rcvFollow.layoutManager = lm
        binding.rcvFollow.adapter = adapter
    }
}