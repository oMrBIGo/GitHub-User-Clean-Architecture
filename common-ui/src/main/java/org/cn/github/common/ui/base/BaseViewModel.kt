package org.cn.github.common.ui.base

import NavigationCommand
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import org.cn.common.R
import org.cn.github.common.ui.model.AlertDialogUi
import org.cn.github.common.ui.model.ToolbarUi
import org.cn.github.common.ui.util.SingleLiveEvent
import org.cn.github.domain.model.CommonError
import org.cn.github.domain.usecase.SecurePreferencesUseCase
import org.koin.java.KoinJavaComponent
import org.cn.github.domain.constant.CommonError as Error

abstract class BaseViewModel() : ViewModel() {
    val progressDialogEvent by lazy { SingleLiveEvent<Boolean>() }
    val alertDialogEvent by lazy { SingleLiveEvent<AlertDialogUi>() }
    val navigateEvent by lazy { SingleLiveEvent<NavigationCommand>() }
    val toolbar by lazy { SingleLiveEvent<ToolbarUi>() }
    val isForceUpdated by lazy { SingleLiveEvent<Pair<Boolean, String>>() }
    val pref: SecurePreferencesUseCase by KoinJavaComponent.inject(SecurePreferencesUseCase::class.java)

    fun initToolbar(
        @StringRes titleRes: Int? = null,
        title: String? = null,
        @DrawableRes navigationIconRes: Int? = R.drawable.ic_back
    ) {
        toolbar.value =
            ToolbarUi(titleRes = titleRes, title = title, navigationIconRes = navigationIconRes)
    }

    fun createTwoButtonDialogEvent(
        title: String? = null,
        message: String? = null,
        @StringRes titleRes: Int? = null,
        @StringRes messageRes: Int? = null,
        @StringRes positiveActionRes: Int? = R.string.General_yes,
        @StringRes negativeActionRes: Int? = R.string.General_no,
        onPositiveClicked: () -> Unit = {},
        onNegativeClicked: () -> Unit = {}
    ) {
        alertDialogEvent.value = AlertDialogUi(
            title = title,
            message = message,
            titleRes = titleRes,
            messageRes = messageRes,
            positiveActionRes = positiveActionRes,
            negativeActionRes = negativeActionRes,
            onPositiveClicked = onPositiveClicked,
            onNegativeClicked = onNegativeClicked
        )
    }

    fun createOneButtonDialogEvent(
        title: String? = null,
        message: String? = null,
        @StringRes titleRes: Int? = null,
        @StringRes messageRes: Int? = null,
        @StringRes positiveActionRes: Int = R.string.General_ok,
        onPositiveClicked: () -> Unit = {}
    ) {
        alertDialogEvent.value = AlertDialogUi(
            title = title,
            message = message,
            titleRes = titleRes,
            messageRes = messageRes,
            positiveActionRes = positiveActionRes,
            onPositiveClicked = onPositiveClicked
        )
    }

    fun createDialogWithImageEvent(
        title: String? = null,
        message: String? = null,
        @DrawableRes imageRes: Int? = null,
        @StringRes titleRes: Int? = null,
        @StringRes messageRes: Int? = null,
        @StringRes positiveActionRes: Int = R.string.General_ok,
        onPositiveClicked: () -> Unit = {},
        @StringRes negativeActionRes: Int? = R.string.General_cancel
    ) {
        alertDialogEvent.value = AlertDialogUi(
            title = title,
            message = message,
            imageRes = imageRes,
            titleRes = titleRes,
            messageRes = messageRes,
            positiveActionRes = positiveActionRes,
            onPositiveClicked = onPositiveClicked
        )
    }

    fun createAlertDialogEvent(
        message: String? = null,
        @StringRes messageRes: Int? = null
    ) {
        createOneButtonDialogEvent(
            message = message,
            titleRes = R.string.Error_Default_title,
            messageRes = messageRes
        )
    }

    fun navigate(navigationCommand: NavigationCommand) {
        navigateEvent.value = navigationCommand
    }

    fun getTheme():Int {
        return pref.getIntSharedPreference(
            pref.getKeyTheme()
        )?:0
    }

    /** Set isHost = true on SplashScreenViewModel only for navigate to login page **/
    fun handlerError(
        error: CommonError,
        onPositiveClicked: () -> Unit = {},
        onClickedForceLogout: () -> Unit = {}
    ) {
        when (error.code) {
            Error.FORCE_LOGOUT.code -> {
                pref.removeSharePreferenceByPrefKey(pref.getKeyToken())
                pref.removeSharePreferenceByPrefKey(pref.getKeyUsername())
                createTwoButtonDialogEvent(message = error.message, onPositiveClicked = onClickedForceLogout)
            }
            Error.FORCE_UPDATE.code -> {
                isForceUpdated.value = Pair(true, error.message)
            }
            else -> {
                createOneButtonDialogEvent(
                    message = error.message,
                    onPositiveClicked = onPositiveClicked
                )
            }
        }
    }

}