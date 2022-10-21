package org.cn.github.di

import okhttp3.Interceptor
import org.cn.github.BuildConfig
import org.cn.github.data.local.di.localModule
import org.cn.github.data.model.di.modelModule
import org.cn.github.data.remote.di.createHttpClient
import org.cn.github.data.remote.di.createRemoteModule
import org.cn.github.data.repository.di.repositoryModule
import org.cn.github.domain.di.createBuildConfigModule
import org.cn.github.domain.di.domainModule
import org.cn.github.home.di.featureHome
import org.cn.github.search.di.featureSearch
import org.cn.github.splashscreen.di.featureSplashScreen

fun createAppModule(interceptor: Interceptor) = listOf(
    createHttpClient(interceptor),
    createRemoteModule(BuildConfig.BASE_API_URL),
    createBuildConfigModule(
        BuildConfig.VERSION_NAME,
        BuildConfig.BUILD_TYPE,
        BuildConfig.VERSION_CODE
    ),
    repositoryModule,
    domainModule,
    modelModule,
    localModule,
    featureHome,
    featureSplashScreen,
    featureSearch
)

