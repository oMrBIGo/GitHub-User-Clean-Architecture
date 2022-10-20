package org.cn.github.domain.utils

class BuildConfigManager(
    private val versionName: String,
    private val buildType: String,
    private val versionCode: Int
) {
    val getVersion : String
        get() = versionName.split("-").first()
}