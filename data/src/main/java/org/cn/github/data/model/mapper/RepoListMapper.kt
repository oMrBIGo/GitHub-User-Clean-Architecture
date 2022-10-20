package org.cn.github.data.model.mapper

import org.cn.github.data.model.RepoListEntity
import org.cn.github.domain.model.RepoList

class RepoListMapper : Mapper<ArrayList<RepoListEntity>, ArrayList<RepoList>> {

    override fun map(input: ArrayList<RepoListEntity>): ArrayList<RepoList> {
        return with(input) {
            getRepoList(this)
        }
    }

    private fun getRepoList(results: ArrayList<RepoListEntity>): ArrayList<RepoList> {
        val list = ArrayList<RepoList>()
        list.add(RepoList())
        results.map { data ->
            list.add(
                RepoList(
                    name = data.name ?: "",
                    description = data.description ?: "",
                    html_url = data.htmlUrl ?: "",
                    created_at = data.createdAt ?: "",
                    updated_at = data.updatedAt ?: "",
                    pushed_at = data.pushedAt ?: "",
                    language = data.language ?: "",
                    stargazers_count = data.stargazersCount ?: 0,
                    forks_count = data.forksCount ?: 0,
                    visibility = data.visibility ?: ""
                )
            )
        }
        return list
    }
}