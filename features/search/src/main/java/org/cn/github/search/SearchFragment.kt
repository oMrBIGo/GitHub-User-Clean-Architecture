package org.cn.github.search

import androidx.recyclerview.widget.LinearLayoutManager
import org.cn.github.common.ui.base.BaseFragment
import org.cn.github.domain.model.SearchUserList
import org.cn.github.search.adapter.SearchListAdapter
import org.cn.github.search.databinding.FragmentSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>() {

    override val viewModel: SearchViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_search
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    private var adapter: SearchListAdapter? = null

    override fun initView() {
        onBackPress()
    }

    override fun initViewModel() {
        viewModel.searchListResult.observe(
            this
        ) {
            setSearchListAdapter(it,viewModel.keyword.value!!)
        }
    }

    private fun setSearchListAdapter(data: ArrayList<SearchUserList.Item>, searchText: String) {
        adapter = SearchListAdapter(
            data,
            object : SearchListAdapter.OnItemClickListener {
                override fun onItemClickListener(login: String, avatarUrl: String) {
                    viewModel.displayUserInfo(login, avatarUrl)
                }
            },
            searchText
        )
        val lm = LinearLayoutManager(requireContext())
        binding.rcvUserSearch.layoutManager = lm
        binding.rcvUserSearch.adapter = adapter
    }

}