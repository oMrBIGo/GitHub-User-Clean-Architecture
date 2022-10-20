package org.cn.github.domain.usecase

import org.cn.github.domain.repository.HomeRepository

class HomeUseCase(private val repo: HomeRepository) {

    suspend fun getUserList() = repo.getUserList()

    suspend fun getRepoList(login: String?) = repo.getRepoList(login)

    suspend fun getFollowList(login: String?) = repo.getFollowList(login)

    suspend fun getUserInfo(login: String?) = repo.getUserInfo(login)
}