package org.cn.github.home

import androidx.recyclerview.widget.LinearLayoutManager
import org.cn.github.common.ui.base.BaseFragment
import org.cn.github.domain.model.UserList
import org.cn.github.home.adapter.UserListAdapter
import org.cn.github.home.databinding.FragmentHomeBinding
import org.cn.github.domain.constant.Language
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_home
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    private var adapter: UserListAdapter? = null

    override fun initView() {
        initToolbar()
        onBackPress()
    }

    private fun initToolbar() {
        viewModel.initToolbar(titleRes = R.string.home_title)
    }

    override fun initViewModel() {
        viewModel.getUsersList()
        viewModel.userListResult.observe(
            this
        ) {
            setUserListAdapter(it)
        }
    }

    private fun setUserListAdapter(data: ArrayList<UserList>) {
        adapter = UserListAdapter(
            data,
            object : UserListAdapter.OnItemClickListener {
                override fun onItemClickListener(login: String, avatarUrl: String) {
                    viewModel.displayUserInfo(login, avatarUrl)
                }
            }
        )
        val lm = LinearLayoutManager(requireContext())
        binding.rcvUserHome.layoutManager = lm
        binding.rcvUserHome.adapter = adapter
    }
}