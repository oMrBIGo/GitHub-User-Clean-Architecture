package org.cn.github.home.repositories

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import org.cn.github.common.ui.base.BaseFragment
import org.cn.github.domain.model.RepoList
import org.cn.github.domain.model.UserList
import org.cn.github.home.BR
import org.cn.github.home.R
import org.cn.github.home.adapter.RepositoriesListAdapter
import org.cn.github.home.adapter.UserListAdapter
import org.cn.github.home.databinding.FragmentRepositoriesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoriesFragment() : BaseFragment<RepositoriesViewModel, FragmentRepositoriesBinding>() {

    private val args: RepositoriesFragmentArgs by navArgs()
    private val login by lazy { args.login }

    override val viewModel: RepositoriesViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_repositories
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    private var adapter: RepositoriesListAdapter? = null

    override fun initView() {
        initToolbar()
    }

    private fun initToolbar() {
        viewModel.initToolbar(title = "")
        binding.toolbarRepositories.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initViewModel() {
        viewModel.login.value = login
        viewModel.getRepoList()
        viewModel.repoListResult.observe(
            this
        ) {
            setRepositoriesAdapter(it)
        }
    }

    private fun setRepositoriesAdapter(data: ArrayList<RepoList>) {
        adapter = RepositoriesListAdapter(
            requireContext(),
            data
        )
        val lm = LinearLayoutManager(requireContext())
        binding.rcvRepositories.layoutManager = lm
        binding.rcvRepositories.adapter = adapter
    }
}