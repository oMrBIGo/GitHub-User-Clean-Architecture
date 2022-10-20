package org.cn.github.domain.di

import org.cn.github.domain.utils.BuildConfigManager
import org.koin.dsl.module

fun createBuildConfigModule(
    versionName: String,
    buildType: String,
    versionCode: Int
) = module {
    single { BuildConfigManager(versionName, buildType, versionCode) }
}