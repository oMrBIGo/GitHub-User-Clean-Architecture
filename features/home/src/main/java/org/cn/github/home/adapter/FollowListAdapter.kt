package org.cn.github.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.cn.github.domain.model.FollowersList
import org.cn.github.home.R
import org.cn.github.home.databinding.ItemFollowBinding

class FollowListAdapter(
    private val context: Context,
    private val result: ArrayList<FollowersList>,
    private val onItemFollowersClickListener: OnItemFollowersClickListener
) : RecyclerView.Adapter<FollowListAdapter.ViewHolder>() {

    interface OnItemFollowersClickListener {
        fun onItemClickListener(login: String, avatarUrl: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_follow,
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

    inner class ViewHolder(private val binding: ItemFollowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            position: Int
        ) {
            binding.model = result[position]
            binding.root.setOnClickListener {
                onItemFollowersClickListener.onItemClickListener(
                    result[position].login,
                    result[position].avatarUrl
                )
            }
            binding.executePendingBindings()
        }
    }
}