package org.cn.github.splashscreen

import NavigationCommand
import org.cn.github.common.ui.base.BaseViewModel
import org.cn.github.domain.constant.Language
import org.cn.github.domain.constant.ThemeType
import org.cn.github.domain.usecase.SecurePreferencesUseCase

class SplashScreenViewModel(
    private val securePreferencesUseCase: SecurePreferencesUseCase,
) : BaseViewModel() {

    var isDarkMode: Boolean = securePreferencesUseCase.getIntSharedPreference(
        securePreferencesUseCase.getKeyTheme()
    ) == 1

    fun checkDefault() {
        if (securePreferencesUseCase.getStringSharedPreference(
                securePreferencesUseCase.getKeyLanguage()).isNullOrEmpty()
        ) {
            securePreferencesUseCase.commitStringSharedPreference(
                securePreferencesUseCase.getKeyLanguage(),
                Language.THAI.id
            )
        }
        if (securePreferencesUseCase.getIntSharedPreference(
                securePreferencesUseCase.getKeyTheme()
            ) == -1
        ) {
            securePreferencesUseCase.commitIntSharedPreference(
                securePreferencesUseCase.getKeyTheme(),
                ThemeType.THEME_LIGHT.id
            )
        }
        isDarkMode = securePreferencesUseCase.getIntSharedPreference(
            securePreferencesUseCase.getKeyTheme()
        ) == 1
    }

    fun displayHome() {
        navigate(
            NavigationCommand.To(
                SplashScreenFragmentDirections.actionSplashScreenFragmentToNavHome()
            )
        )
    }
}