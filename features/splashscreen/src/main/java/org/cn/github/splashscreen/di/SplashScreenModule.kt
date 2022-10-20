package org.cn.github.splashscreen.di

import org.cn.github.splashscreen.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureSplashScreen = module {
    viewModel { SplashScreenViewModel(get()) }
}