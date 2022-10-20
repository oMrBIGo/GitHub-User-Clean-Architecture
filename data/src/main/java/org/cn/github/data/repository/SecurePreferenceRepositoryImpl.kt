package org.cn.github.data.repository

import org.cn.github.data.local.sharedpreferences.SecurePreferences
import org.cn.github.domain.repository.SecurePreferenceRepository

class SecurePreferenceRepositoryImpl(private val prefs: SecurePreferences) :
    SecurePreferenceRepository {

    companion object {
        const val token = "3c469e9d6c5875d37a43f353d4f88e61fcf812c66eee3457465a40b0da4153e0"
        const val language = "a4ef304ba42a200bafd78b046e0869af9183f6eee5524aead5dcb3a5ab5f8f3f"
        const val theme = "3cb8201e7ff1e7777446032ef1bf4338535aadbabe464c15411cdce8c2317590"
        const val email = "82244417f956ac7c599f191593f7e441a4fafa20a4158fd52e154f1dc4c8ed92"
        const val password = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8"
        const val username = "16f78a7d6317f102bbd95fc9a4f3ff2e3249287690b8bdad6b7810f82b34ace3"
    }

    override fun commitIntSharedPreference(prefKey: String, value: Int) {
        prefs.commitIntSharedPreference(prefKey, value)
    }

    override fun getIntSharedPreference(prefKey: String): Int? {
        return prefs.getIntSharedPreference(prefKey)
    }

    override fun commitBooleanSharedPreference(prefKey: String, value: Boolean) {
        prefs.commitBooleanSharedPreference(prefKey, value)
    }

    override fun getBooleanSharedPreference(prefKey: String): Boolean? {
        return prefs.getBooleanSharedPreference(prefKey)
    }

    override fun commitStringSharedPreference(prefKey: String, value: String?) {
        prefs.commitStringSharedPreference(prefKey, value)
    }

    override fun getStringSharedPreference(prefKey: String): String? {
        return prefs.getStringSharedPreference(prefKey)
    }

    override fun commitLongSharedPreference(prefKey: String, value: Long) {
        prefs.commitLongSharedPreference(prefKey, value)
    }

    override fun getLongSharedPreference(prefKey: String): Long? {
        return prefs.getLongSharedPreference(prefKey)
    }

    override fun commitArrayStringSharedPreference(prefKey: String, value: ArrayList<*>) {
        prefs.commitArrayStringSharedPreference(prefKey, value)
    }

    override fun getArrayStringSharedPreference(prefKey: String): ArrayList<*>? {
        return prefs.getArrayStringSharedPreference(prefKey)
    }

    override fun removeSharePreferenceByPrefKey(prefKey: String) {
        prefs.removeSharePreferenceByPrefKey(prefKey)
    }

    override fun getAllKeyPreference(): MutableMap<String, *>? {
        return prefs.getAllKeyPreference()
    }

    override fun getKeyLanguage(): String {
        return language
    }

    override fun getKeyToken(): String {
        return token
    }

    override fun getKeyTheme(): String {
        return theme
    }

    override fun getKeyEmail(): String {
        return email
    }

    override fun getKeyPassword(): String {
        return password
    }

    override fun getKeyUsername(): String {
        return username
    }

}