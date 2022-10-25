package org.cn.github.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.cn.github.domain.model.OrganizationList
import org.cn.github.home.R
import org.cn.github.home.databinding.ItemOrganizationBinding

class OrganizationListAdapter(
    private val context: Context,
    private val result: ArrayList<OrganizationList>,
) : RecyclerView.Adapter<OrganizationListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_organization,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return result.size
    }

    inner class ViewHolder(private val binding: ItemOrganizationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            position: Int,
        ) {
            binding.model = result[position]
            binding.executePendingBindings()
        }
    }
}