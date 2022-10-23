package org.cn.github.data.repository

import org.cn.github.data.model.mapper.UserListMapper
import org.cn.github.data.remote.search.SearchService
import org.cn.github.domain.model.CommonError
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.UserList
import org.cn.github.domain.model.mapOnSuccess
import org.cn.github.domain.repository.SearchRepository
import org.cn.github.domain.usecase.SearchUseCase

class SearchRepositoryImpl(
    private val userListMapper: UserListMapper,
    private val searchService: SearchService
) : SearchRepository {

    override suspend fun getUserList(): NetworkResponse<ArrayList<UserList>, CommonError>? {
        return searchService.getUserList().mapOnSuccess(userListMapper::map)
    }

}