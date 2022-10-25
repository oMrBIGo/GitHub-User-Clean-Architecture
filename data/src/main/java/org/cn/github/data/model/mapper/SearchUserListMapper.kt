package org.cn.github.data.model.mapper

import org.cn.github.data.model.SearchUserListEntity
import org.cn.github.domain.model.SearchUserList

class SearchUserListMapper : Mapper<SearchUserListEntity?, ArrayList<SearchUserList.Item>> {
   
    override fun map(input: SearchUserListEntity?): ArrayList<SearchUserList.Item> {
        return with(input) {
            getItemList(input)
        }
    }

    private fun getItemList(
        results: SearchUserListEntity?
    ): ArrayList<SearchUserList.Item> {
        val itemList = ArrayList<SearchUserList.Item>()
        results?.items?.map { data ->
            itemList.add(
                SearchUserList.Item(
                    avatarUrl = data?.avatarUrl ?: "",
                    eventsUrl = data?.eventsUrl ?: "",
                    followersUrl = data?.followersUrl ?: "",
                    followingUrl = data?.followingUrl ?: "",
                    gistsUrl = data?.gistsUrl ?: "",
                    gravatarId = data?.gravatarId ?: "",
                    htmlUrl = data?.htmlUrl ?: "",
                    id = data?.id ?: 0,
                    login = data?.login ?: "",
                    nodeId = data?.nodeId ?: "",
                    organizationsUrl = data?.organizationsUrl ?: "",
                    receivedEventsUrl = data?.receivedEventsUrl ?: "",
                    reposUrl = data?.reposUrl ?: "",
                    score = data?.score ?: 0.0,
                    siteAdmin = data?.siteAdmin ?: false,
                    starredUrl = data?.starredUrl ?: "",
                    subscriptionsUrl = data?.subscriptionsUrl ?: "",
                    type = data?.type ?: "",
                    url = data?.url ?: ""
                )
            )
        }
        return itemList
    }
}