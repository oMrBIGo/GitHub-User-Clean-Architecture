package org.cn.github.setting.di

import org.cn.github.setting.SettingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureSetting = module {
    viewModel { SettingViewModel() }
}