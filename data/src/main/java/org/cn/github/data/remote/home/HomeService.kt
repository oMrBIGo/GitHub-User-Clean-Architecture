package org.cn.github.data.remote.home

import org.cn.github.data.model.RepoListEntity
import org.cn.github.data.model.UserInfoEntity
import org.cn.github.data.model.UserListEntity
import org.cn.github.domain.model.CommonError
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.UserInfo
import retrofit2.Call
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
    ): NetworkResponse<ArrayList<UserListEntity>, CommonError>

    @GET("users/{login}")
    suspend fun getUserinfo(
        @Path("login") login: String?
    ): NetworkResponse<UserInfoEntity, CommonError>
}