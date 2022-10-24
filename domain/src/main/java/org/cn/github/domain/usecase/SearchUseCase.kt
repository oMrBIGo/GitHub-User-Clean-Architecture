package org.cn.github.domain.usecase

import org.cn.github.domain.repository.SearchRepository

class SearchUseCase(private val repo: SearchRepository) {

    suspend fun getSearchUser(
        q: String?
    ) = repo.getSearchUser(q)
}