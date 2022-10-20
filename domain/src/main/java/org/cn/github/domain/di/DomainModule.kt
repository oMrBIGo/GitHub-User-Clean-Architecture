package org.cn.github.domain.di

import org.cn.github.domain.usecase.HomeUseCase
import org.cn.github.domain.usecase.SecurePreferencesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { SecurePreferencesUseCase(get()) }
    single { HomeUseCase(get()) }
}