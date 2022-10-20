package org.cn.github.data.local.di

import org.cn.github.data.local.sharedpreferences.SecurePreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single { SecurePreferences(androidContext()) }
}