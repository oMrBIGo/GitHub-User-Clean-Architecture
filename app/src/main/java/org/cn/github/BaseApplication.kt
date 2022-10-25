package org.cn.github

import android.app.Application
import android.content.res.Configuration
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.facebook.stetho.Stetho
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.cn.github.data.local.sharedpreferences.SecurePreferences
import org.cn.github.di.createAppModule
import org.cn.github.domain.utils.LocaleManager
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@ExperimentalCoroutinesApi
@FlowPreview
val sharedPreferences : SecurePreferences by lazy {
    BaseApplication.prefs!!
}

@FlowPreview
@ExperimentalCoroutinesApi
open class BaseApplication : Application() {

    companion object{
        var prefs : SecurePreferences? = null
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        configureDi()
    }

    open fun configureDi() =
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                createAppModule(
                    interceptor = ChuckerInterceptor.Builder(
                        applicationContext
                    ).build()
                )
            )
        }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManager.setLocale(this)
    }
}