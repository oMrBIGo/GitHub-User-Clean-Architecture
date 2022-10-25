package org.cn.github.favorite

import androidx.recyclerview.widget.LinearLayoutManager
import org.cn.github.common.ui.base.BaseFragment
import org.cn.github.favorite.adapter.FavoriteAdapter
import org.cn.github.favorite.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FavoriteViewModel, FragmentFavoriteBinding>() {

    override val viewModel: FavoriteViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_favorite
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    private var adapter: FavoriteAdapter? = null

    override fun initView() {

    }

    override fun initViewModel() {

    }

    fun setFavoriteAdapter(data: ArrayList<String>) {
        adapter = FavoriteAdapter(
            requireContext(),
            data
        )
        val lm = LinearLayoutManager(requireContext())
        binding.rcvFav.layoutManager = lm
        binding.rcvFav.adapter = adapter
    }
}