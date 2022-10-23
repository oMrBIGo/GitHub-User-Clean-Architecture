package org.cn.github.search.di

import org.cn.github.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureSearch = module {
    viewModel { SearchViewModel(get()) }
}