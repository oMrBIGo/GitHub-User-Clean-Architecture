package org.cn.github.data.repository

import org.cn.github.data.model.mapper.SearchUserListMapper
import org.cn.github.data.remote.search.SearchService
import org.cn.github.domain.model.CommonError
import org.cn.github.domain.model.NetworkResponse
import org.cn.github.domain.model.SearchUserList
import org.cn.github.domain.model.mapOnSuccess
import org.cn.github.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val searchUserListMapper: SearchUserListMapper,
    private val searchService: SearchService
) : SearchRepository {
    override suspend fun getSearchUser(q: String?): NetworkResponse<ArrayList<SearchUserList.Item>, CommonError>? {
        return searchService.getSearchUser(
            q
        ).mapOnSuccess(searchUserListMapper::map)
    }


}