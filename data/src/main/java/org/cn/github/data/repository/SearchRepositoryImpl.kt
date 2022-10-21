package org.cn.github.data.repository

import org.cn.github.domain.repository.SearchRepository
import org.cn.github.domain.usecase.SearchUseCase

class SearchRepositoryImpl(
    private val searchUseCase: SearchUseCase
) : SearchRepository {
}