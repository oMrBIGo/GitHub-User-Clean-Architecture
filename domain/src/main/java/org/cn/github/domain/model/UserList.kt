package org.cn.github.domain.model

data class UserList(
        val avatarUrl: String = "",
        val eventsUrl: String = "",
        val followersUrl: String = "",
        val followingUrl: String = "",
        val gistsUrl: String = "",
        val gravatarId: String = "",
        val htmlUrl: String = "",
        val id: Int = 0,
        val login: String = "",
        val nodeId: String = "",
        val organizationsUrl: String = "",
        val receivedEventsUrl: String = "",
        val reposUrl: String = "",
        val siteAdmin: Boolean = false,
        val starredUrl: String = "",
        val subscriptionsUrl: String = "",
        val type: String = "",
        val url: String = ""
)