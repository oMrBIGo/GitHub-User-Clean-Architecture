package org.cn.github.search

import org.cn.github.common.ui.base.BaseFragment
import org.cn.github.search.databinding.FragmentSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>() {

    override val viewModel: SearchViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_search
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
        initToolbar()
    }

    private fun initToolbar() {
        viewModel.initToolbar(titleRes = R.string.search_title)
    }

    override fun initViewModel() {

    }

}