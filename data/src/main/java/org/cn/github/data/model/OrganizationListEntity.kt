package org.cn.github.data.model


import com.google.gson.annotations.SerializedName

data class OrganizationListEntity(
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("events_url")
    val eventsUrl: String?,
    @SerializedName("hooks_url")
    val hooksUrl: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("issues_url")
    val issuesUrl: String?,
    @SerializedName("login")
    val login: String?,
    @SerializedName("members_url")
    val membersUrl: String?,
    @SerializedName("node_id")
    val nodeId: String?,
    @SerializedName("public_members_url")
    val publicMembersUrl: String?,
    @SerializedName("repos_url")
    val reposUrl: String?,
    @SerializedName("url")
    val url: String?,
)
