package org.cn.github.favorite.di

import org.cn.github.favorite.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureFavorite = module {
    viewModel { FavoriteViewModel() }
}