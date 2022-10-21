package org.cn.github.data.remote.home

import org.cn.github.data.model.*
import org.cn.github.domain.model.CommonError
import org.cn.github.domain.model.FollowersList
import org.cn.github.domain.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeService {

    @GET("users")
    suspend fun getUserList(): NetworkResponse<ArrayList<UserListEntity>, CommonError>

    @GET("users/{login}/repos")
    suspend fun getRepoList(
        @Path("login") login: String?
    ): NetworkResponse<ArrayList<RepoListEntity>, CommonError>

    @GET("users/{login}/followers")
    suspend fun getFollowList(
        @Path("login") login: String?
    ): NetworkResponse<ArrayList<FollowersListEntity>, CommonError>

    @GET("users/{login}")
    suspend fun getUserinfo(
        @Path("login") login: String?
    ): NetworkResponse<UserInfoEntity, CommonError>

    @GET("users/{login}/orgs")
    suspend fun getOrganization(
        @Path("login") login: String?
    ): NetworkResponse<ArrayList<OrganizationListEntity>, CommonError>
}