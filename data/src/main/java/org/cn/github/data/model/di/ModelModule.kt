package org.cn.github.data.model.di

import org.cn.github.data.model.mapper.*
import org.koin.dsl.module

val modelModule = module {
    single { ReturnNullMapper() }
    single { UserListMapper() }
    single { RepoListMapper() }
    single { FollowMapper() }
    single { UserInfoMapper() }
    single { OrganizationMapper() }
    single { SearchUserListMapper() }
}