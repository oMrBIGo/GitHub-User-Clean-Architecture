package org.cn.github.home.di

import org.cn.github.home.HomeViewModel
import org.cn.github.home.follow.FollowViewModel
import org.cn.github.home.more.UserMoreViewModel
import org.cn.github.home.organization.OrganizationViewModel
import org.cn.github.home.repositories.RepositoriesViewModel
import org.cn.github.home.userInfo.UserInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureHome = module {
    viewModel { HomeViewModel(get(), get(), get()) }
    viewModel { UserMoreViewModel(get()) }
    viewModel { RepositoriesViewModel(get()) }
    viewModel { FollowViewModel(get()) }
    viewModel { UserInfoViewModel(get(), get()) }
    viewModel { OrganizationViewModel(get()) }
}