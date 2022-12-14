package org.cn.github.domain.repository

import org.cn.github.domain.model.*

interface HomeRepository {

    suspend fun getUserList(): NetworkResponse<ArrayList<UserList>, CommonError>?

    suspend fun getRepoList(
        login: String?
    ): NetworkResponse<ArrayList<RepoList>, CommonError>?

    suspend fun getFollowList(
        login: String?
    ): NetworkResponse<ArrayList<FollowersList>, CommonError>?

    suspend fun getUserInfo(
        login: String?
    ): NetworkResponse<UserInfo, CommonError>?

    suspend fun getOrganizationList(
        login: String?
    ): NetworkResponse<ArrayList<OrganizationList>, CommonError>?
}