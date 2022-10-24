package org.cn.github.data.remote.search

import org.cn.github.data.model.SearchUserListEntity
import org.cn.github.domain.model.CommonError
import org.cn.github.domain.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET("search/users?")
    suspend fun getSearchUser(
        @Query("q") q : String?
    ) : NetworkResponse<SearchUserListEntity, CommonError>
}