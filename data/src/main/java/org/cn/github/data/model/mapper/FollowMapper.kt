package org.cn.github.data.model.mapper

import org.cn.github.data.model.UserListEntity
import org.cn.github.domain.model.UserList

class FollowMapper : Mapper<ArrayList<UserListEntity>, ArrayList<UserList>> {

    override fun map(input: ArrayList<UserListEntity>): ArrayList<UserList> {
        return with(input) {
            getFollowList(this)
        }
    }

    private fun getFollowList(result: ArrayList<UserListEntity>): ArrayList<UserList> {
        val list = ArrayList<UserList>()
        list.add(UserList())
        result.map { data ->
            list.add(
                UserList(
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