package org.cn.github.data.remote.search

import org.cn.github.data.model.UserListEntity
import org.cn.github.domain.model.CommonError
import org.cn.github.domain.model.NetworkResponse
import retrofit2.http.GET

interface SearchService {

    @GET("users")
    suspend fun getUserList(): NetworkResponse<ArrayList<UserListEntity>, CommonError>
}