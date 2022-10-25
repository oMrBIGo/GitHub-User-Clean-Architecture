package org.cn.github.domain.repository

interface SecurePreferenceRepository {
    fun commitIntSharedPreference(prefKey: String, value: Int)
    fun getIntSharedPreference(prefKey: String): Int?
    fun commitBooleanSharedPreference(prefKey: String, value: Boolean)
    fun getBooleanSharedPreference(prefKey: String): Boolean?
    fun commitStringSharedPreference(prefKey: String, value: String?)
    fun getStringSharedPreference(prefKey: String): String?
    fun commitLongSharedPreference(prefKey: String, value: Long)
    fun getLongSharedPreference(prefKey: String): Long?
    fun commitArrayStringSharedPreference(prefKey: String, value: ArrayList<*>)
    fun getArrayStringSharedPreference(prefKey: String): ArrayList<*>?
    fun removeSharePreferenceByPrefKey(prefKey: String)

    fun getAllKeyPreference(): MutableMap<String, *>?
    fun getKeyLanguage(): String
    fun getKeyToken(): String
    fun getKeyTheme(): String
    fun getKeyEmail(): String
    fun getKeyPassword(): String
    fun getKeyUsername(): String
    fun getKeyFavorite(): String

}