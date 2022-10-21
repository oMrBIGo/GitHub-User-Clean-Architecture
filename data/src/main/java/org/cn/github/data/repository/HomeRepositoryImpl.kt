package org.cn.github.data.repository

import org.cn.github.data.model.mapper.*
import org.cn.github.data.remote.home.HomeService
import org.cn.github.domain.model.*
import org.cn.github.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val userListMapper: UserListMapper,
    private val repoListMapper: RepoListMapper,
    private val followMapper: FollowMapper,
    private val userInfoMapper: UserInfoMapper,
    private val organizationMapper: OrganizationMapper,
    private val homeService: HomeService
) : HomeRepository {

    override suspend fun getUserList(): NetworkResponse<ArrayList<UserList>, CommonError>? {
        return homeService.getUserList().mapOnSuccess(userListMapper::map)
    }

    override suspend fun getRepoList(login: String?): NetworkResponse<ArrayList<RepoList>, CommonError>? {
        return homeService.getRepoList(
            login
        ).mapOnSuccess(repoListMapper::map)
    }

    override suspend fun getFollowList(login: String?): NetworkResponse<ArrayList<FollowersList>, CommonError>? {
        return homeService.getFollowList(
            login
        ).mapOnSuccess(followMapper::map)
    }

    override suspend fun getUserInfo(login: String?): NetworkResponse<UserInfo, CommonError>? {
        return homeService.getUserinfo(
            login
        ).mapOnSuccess(userInfoMapper::map)
    }

    override suspend fun getOrganizationList(login: String?): NetworkResponse<ArrayList<OrganizationList>, CommonError>? {
        return homeService.getOrganization(
            login
        ).mapOnSuccess(organizationMapper::map)
    }
}