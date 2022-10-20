package org.cn.github.data.model.mapper

import org.cn.github.data.model.UserInfoEntity
import org.cn.github.domain.model.UserInfo

class UserInfoMapper : Mapper<UserInfoEntity, UserInfo> {

    override fun map(input: UserInfoEntity): UserInfo {
        return with(input) {
            UserInfo(
                avatarUrl = avatarUrl ?: "",
                bio = bio ?: "",
                blog = blog ?: "",
                company = company ?: "",
                createdAt = createdAt ?: "",
                email = email ?: "",
                eventsUrl = eventsUrl ?: "",
                followers = followers ?: 0,
                followersUrl = followersUrl ?: "",
                following = following ?: 0,
                followingUrl = followingUrl ?: "",
                gistsUrl = gistsUrl ?: "",
                gravatarId = gravatarId ?: "",
                hireable = hireable ?: "",
                htmlUrl = htmlUrl ?: "",
                id = id ?: 0,
                location = location ?: "",
                login = login ?: "",
                name = name ?: "",
                nodeId = nodeId ?: "",
                organizationsUrl = organizationsUrl ?: "",
                publicGists = publicGists ?: 0,
                publicRepos = publicRepos ?: 0,
                receivedEventsUrl = receivedEventsUrl ?: "",
                reposUrl = reposUrl ?: "",
                siteAdmin = siteAdmin ?: false,
                starredUrl = starredUrl ?: "",
                subscriptionsUrl = subscriptionsUrl ?: "",
                twitterUsername = twitterUsername ?: "",
                type = type ?: "",
                updatedAt = updatedAt ?: "")
        }
    }
}