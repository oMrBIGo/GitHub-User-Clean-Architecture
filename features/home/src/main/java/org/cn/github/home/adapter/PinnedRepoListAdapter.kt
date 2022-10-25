package org.cn.github.home.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.cn.github.common.ui.binding.bindImage
import org.cn.github.domain.model.RepoList
import org.cn.github.home.R
import org.cn.github.home.databinding.ItemPinnedRepoBinding

class PinnedRepoListAdapter(
    private val context: Context,
    private val result: ArrayList<RepoList>,
    private val avatarUrl: String,
    private val login: String
) : RecyclerView.Adapter<PinnedRepoListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_pinned_repo,
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

    inner class ViewHolder(private val binding: ItemPinnedRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            position: Int,
        ) {
            binding.model = result[position]
            bindImage(binding.civPinnedRepo, avatarUrl)
            binding.txvUserPinnedRepo.text = login
            binding.root.setOnClickListener {
                if (!result[position].html_url.isNullOrEmpty()) openWeb(result[position].html_url) else Toast.makeText(
                    context,
                    R.string.Error_NotFound_data,
                    Toast.LENGTH_SHORT).show()
            }
            binding.executePendingBindings()
        }

        fun openWeb(url: String) {
            if (!url.isNullOrEmpty()) {
                val builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
                val customTabsIntent: CustomTabsIntent = builder.build()
                customTabsIntent.launchUrl(context, Uri.parse(url))
            }
        }
    }
}