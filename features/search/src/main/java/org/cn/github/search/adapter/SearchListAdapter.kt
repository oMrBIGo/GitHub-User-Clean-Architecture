package org.cn.github.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.cn.github.domain.model.UserList
import org.cn.github.search.R
import org.cn.github.search.databinding.ItemSearchListBinding

class SearchListAdapter(
    private val result: ArrayList<UserList>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<SearchListAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClickListener(login: String, avatarUrl: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_search_list,
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

    inner class ViewHolder(private val binding: ItemSearchListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            position: Int
        ) {
            binding.model = result[position]
            binding.executePendingBindings()
        }
    }
}