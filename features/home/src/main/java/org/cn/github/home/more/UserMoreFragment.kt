package org.cn.github.home.more

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.cn.github.common.ui.base.BaseFragment
import org.cn.github.domain.model.UserList
import org.cn.github.home.BR
import org.cn.github.home.R
import org.cn.github.home.adapter.UserAllListAdapter
import org.cn.github.home.adapter.UserListAdapter
import org.cn.github.home.databinding.FragmentUserMoreBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserMoreFragment() : BaseFragment<UserMoreViewModel, FragmentUserMoreBinding>() {

    override val viewModel: UserMoreViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_user_more
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    private var adapter: UserAllListAdapter? = null

    override fun initView() {
        initToolbar()
    }

    private fun initToolbar() {
        viewModel.initToolbar(title = "")
        binding.toolbarUserMore.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initViewModel() {
        viewModel.getUsersList()
        viewModel.userAllListResult.observe(
            this
        ) {
            setUserAllListAdapter(it)
        }
    }

    private fun setUserAllListAdapter(data: ArrayList<UserList>) {
        adapter = UserAllListAdapter(
            data,
            object : UserAllListAdapter.OnItemClickListener {
                override fun onItemClickListener(login: String, avatar: String) {
                    viewModel.displayUserInfo(login, avatar)
                }
            },
        )
        val lm = LinearLayoutManager(requireContext())
        binding.rcvUserMore.layoutManager = lm
        binding.rcvUserMore.adapter = adapter
    }
}
