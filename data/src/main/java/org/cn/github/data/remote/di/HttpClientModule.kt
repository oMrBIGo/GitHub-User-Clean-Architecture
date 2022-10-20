package org.cn.github.data.remote.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.cn.github.data.remote.interceptor.HeaderInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun createHttpClient(chuckerInterceptor: Interceptor) = module {
    single(named("httpLoggingInterceptor")) {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    single(named("stethoInterceptor")) {
        StethoInterceptor()
    }
    single(named("headerInterceptor")) {
        HeaderInterceptor(
            get(),
            get()
        )
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>(named("httpLoggingInterceptor")))
            .addInterceptor(get<HeaderInterceptor>(named("headerInterceptor")))
            .addNetworkInterceptor(get<StethoInterceptor>(named("stethoInterceptor")))
            .addNetworkInterceptor(chuckerInterceptor)
            .build()
    }
}
