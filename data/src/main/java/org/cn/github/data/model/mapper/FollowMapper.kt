package org.cn.github.data.model.mapper

import org.cn.github.data.model.FollowersListEntity
import org.cn.github.data.model.UserListEntity
import org.cn.github.domain.model.FollowersList
import org.cn.github.domain.model.UserList

class FollowMapper : Mapper<ArrayList<FollowersListEntity>, ArrayList<FollowersList>> {

    override fun map(input: ArrayList<FollowersListEntity>): ArrayList<FollowersList> {
        return with(input) {
            getFollowList(this)
        }
    }

    private fun getFollowList(result: ArrayList<FollowersListEntity>): ArrayList<FollowersList> {
        val list = ArrayList<FollowersList>()
        result.map { data ->
            list.add(
                FollowersList(
                    avatarUrl = data.avatarUrl ?: "",
                    eventsUrl = data.eventsUrl ?: "",
                    followersUrl = data.followersUrl ?: "",
                    followingUrl = data.followingUrl ?: "",
                    gistsUrl = data.gistsUrl ?: "",
                    gravatarId = data.gravatarId ?: "",
                    htmlUrl = data.htmlUrl ?: "",
                    id = data.id ?: 0,
                    login = data.login ?: "",
                    nodeId = data.nodeId ?: "",
                    organizationsUrl = data.organizationsUrl ?: "",
                    receivedEventsUrl = data.receivedEventsUrl ?: "",
                    reposUrl = data.reposUrl ?: "",
                    siteAdmin = data.siteAdmin ?: false,
                    starredUrl = data.starredUrl ?: "",
                    subscriptionsUrl = data.subscriptionsUrl ?: "",
                    type = data.type ?: "",
                    url = data.url ?: "")
            )
        }
        return list
    }
}