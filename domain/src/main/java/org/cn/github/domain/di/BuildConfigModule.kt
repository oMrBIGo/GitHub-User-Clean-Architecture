package org.cn.github.domain.di

import org.koin.dsl.module

fun createBuildConfigModule(
    versionName: String,
    buildType: String,
    versionCode: Int
) = module {
    single { }
}