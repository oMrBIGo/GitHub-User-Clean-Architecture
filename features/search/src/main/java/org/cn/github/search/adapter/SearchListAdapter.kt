package org.cn.github.search.adapter

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.BackgroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.cn.github.domain.model.SearchUserList
import org.cn.github.search.R
import org.cn.github.search.databinding.ItemSearchListBinding

class SearchListAdapter(
    private val result: ArrayList<SearchUserList.Item>,
    private val onItemClickListener: OnItemClickListener,
    private val searchText: String?,
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
            position: Int,
        ) {
            binding.model = result[position]
            val login = result[position].login
            if (searchText!!.isNotEmpty() && login.contains(searchText)) {
                val sb = SpannableStringBuilder(login)
                var index: Int = (login.indexOf(searchText))
                while (index >= 0 && index < login.length) {
                    val fcs = BackgroundColorSpan(Color.rgb(0, 200, 200))
                    sb.setSpan(
                        fcs,
                        index,
                        index + searchText.length,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                    index = login.indexOf(searchText, index + 1)
                }
                binding.txvTitleItemSearchList.text = sb
            } else {
                binding.txvTitleItemSearchList.text = login
            }
            initEvent()
            binding.executePendingBindings()
        }

        private fun initEvent() {
            binding.root.setOnClickListener {
                onItemClickListener.onItemClickListener(
                    result[position].login,
                    result[position].avatarUrl
                )
            }
        }
    }
}