package org.cn.github.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.cn.github.domain.model.UserList
import org.cn.github.home.R
import org.cn.github.home.databinding.ItemUserListBinding

class UserListAdapter(
    private val result: ArrayList<UserList>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClickListener(login: String, avatarUrl: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_user_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return 6
    }

    inner class ViewHolder(private val binding: ItemUserListBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(
            position: Int
        ) {
            binding.model = result[position]
            binding.root.setOnClickListener {
                onItemClickListener.onItemClickListener(
                    result[position].login,
                    result[position].avatarUrl
                )
            }
            binding.executePendingBindings()
        }
    }
}