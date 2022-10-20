package org.cn.github.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.cn.github.domain.usecase.SecurePreferencesUseCase
import org.cn.github.domain.utils.BuildConfigManager
import java.util.*

class HeaderInterceptor(
    private val pref: SecurePreferencesUseCase,
    private val builderConfigManager: BuildConfigManager
) : Interceptor {

    companion object {
        const val PLATFORM = "ANDROID"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        /*
        val newRequest = request.newBuilder().apply {
            addHeader("token", "Bearer ${pref.getStringSharedPreference(pref.getKeyToken()) ?: ""}")
            addHeader(
                "language",
                pref.getStringSharedPreference(pref.getKeyLanguage()) ?: Locale.getDefault().language
            )
            addHeader("platform", PLATFORM)
            addHeader("version", builderConfigManager.getVersion)
            method(request.method, request.body)
        }.build()
         */
    return chain.proceed(request)
    }

}