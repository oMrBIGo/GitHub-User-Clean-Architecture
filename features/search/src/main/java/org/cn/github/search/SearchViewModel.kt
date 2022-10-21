package org.cn.github.search

import org.cn.github.common.ui.base.BaseViewModel
import org.cn.github.domain.usecase.SearchUseCase
import org.cn.github.domain.usecase.SecurePreferencesUseCase
import org.cn.github.domain.utils.BuildConfigManager
import org.cn.github.home.HomeFragmentDirections

class SearchViewModel(
    private val searchUseCase: SearchUseCase,
    private val securePreferencesUseCase: SecurePreferencesUseCase,
    private val buildConfigManager: BuildConfigManager
) : BaseViewModel() {

}