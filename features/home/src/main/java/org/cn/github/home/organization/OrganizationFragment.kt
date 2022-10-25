package org.cn.github.home.organization

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import org.cn.github.common.ui.base.BaseFragment
import org.cn.github.domain.model.OrganizationList
import org.cn.github.home.BR
import org.cn.github.home.R
import org.cn.github.home.adapter.OrganizationListAdapter
import org.cn.github.home.databinding.FragmentOrganizationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrganizationFragment: BaseFragment<OrganizationViewModel,FragmentOrganizationBinding>() {

    private val args: OrganizationFragmentArgs by navArgs()
    private val login by lazy { args.login }

    override val viewModel: OrganizationViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_organization
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    private var adapter: OrganizationListAdapter? = null

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
        viewModel.getOrganizationList()
        viewModel.organizationResult.observe(
            this
        ) {
            setOrganizationAdapter(it)
        }
    }

    private fun setOrganizationAdapter(data: ArrayList<OrganizationList>) {
        adapter = OrganizationListAdapter(
            requireContext(),
            data
        )
        val lm = LinearLayoutManager(requireContext())
        binding.rcvOrganization.layoutManager = lm
        binding.rcvOrganization.adapter = adapter
    }
}