package org.cn.github.domain.repository

import org.cn.github.domain.model.CommonError
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.UserList

interface SearchRepository {

    suspend fun getUserList(): NetworkResponse<ArrayList<UserList>, CommonError>?

}