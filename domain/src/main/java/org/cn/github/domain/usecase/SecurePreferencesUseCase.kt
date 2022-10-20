package org.cn.github.domain.usecase

import org.cn.github.domain.repository.SecurePreferenceRepository

class SecurePreferencesUseCase(private val repo: SecurePreferenceRepository) {

    fun commitIntSharedPreference(prefKey: String, value: Int) =
        repo.commitIntSharedPreference(prefKey, value)

    fun getIntSharedPreference(prefKey: String) = repo.getIntSharedPreference(prefKey)

    fun commitBooleanSharedPreference(prefKey: String, value: Boolean) =
        repo.commitBooleanSharedPreference(prefKey, value)

    fun getBooleanSharedPreference(prefKey: String) = repo.getBooleanSharedPreference(prefKey)

    fun commitStringSharedPreference(prefKey: String, value: String?) =
        repo.commitStringSharedPreference(prefKey, value)

    fun getStringSharedPreference(prefKey: String) =
        repo.getStringSharedPreference(prefKey)

    fun commitLongSharedPreference(prefKey: String, value: Long) =
        repo.commitLongSharedPreference(prefKey, value)

    fun getLongSharedPreference(prefKey: String) = repo.getLongSharedPreference(prefKey)

    fun commitArrayStringSharedPreference(prefKey: String, value: ArrayList<*>) =
        repo.commitArrayStringSharedPreference(prefKey, value)

    fun getArrayStringSharedPreference(prefKey: String) = repo.getArrayStringSharedPreference(prefKey)

    fun removeSharePreferenceByPrefKey(prefKey: String) = repo.removeSharePreferenceByPrefKey(prefKey)

    fun getAllKeyPreference() = repo.getAllKeyPreference()

    fun getKeyLanguage() = repo.getKeyLanguage()

    fun getKeyToken() = repo.getKeyToken()

    fun getKeyTheme() = repo.getKeyTheme()

    fun getKeyEmail() = repo.getKeyEmail()

    fun getKeyPassword() = repo.getKeyPassword()

    fun getKeyUsername() = repo.getKeyUsername()

}