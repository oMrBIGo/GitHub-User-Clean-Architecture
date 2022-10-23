package org.cn.github.data.repository.di

import org.cn.github.data.repository.HomeRepositoryImpl
import org.cn.github.data.repository.SearchRepositoryImpl
import org.cn.github.data.repository.SecurePreferenceRepositoryImpl
import org.cn.github.domain.repository.HomeRepository
import org.cn.github.domain.repository.SearchRepository
import org.cn.github.domain.repository.SecurePreferenceRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<SecurePreferenceRepository> { SecurePreferenceRepositoryImpl(get()) }
    single<HomeRepository> { HomeRepositoryImpl(get(), get(), get(), get(), get(), get()) }
    single<SearchRepository> { SearchRepositoryImpl(get(), get()) }
}