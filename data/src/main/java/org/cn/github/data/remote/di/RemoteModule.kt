package org.cn.github.data.remote.di

import org.cn.github.data.remote.home.HomeService
import org.cn.github.data.remote.search.SearchService
import org.cn.github.data.utils.NetworkResponseAdapterFactory
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRemoteModule(baseApiUrl: String) = module {
    single(named("retrofit")) {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseApiUrl)
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>(named("retrofit")).create(HomeService::class.java) }
    single { get<Retrofit>(named("retrofit")).create(SearchService::class.java) }
}