package org.cn.github.domain.repository

import org.cn.github.domain.model.CommonError
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.SearchUserList

interface SearchRepository {

    suspend fun getSearchUser(
        q: String?
    ): NetworkResponse<ArrayList<SearchUserList.Item>, CommonError>?

}