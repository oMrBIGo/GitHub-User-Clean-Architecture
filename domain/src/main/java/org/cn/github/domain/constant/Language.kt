package org.cn.github.domain.constant

import org.cn.github.domain.R

enum class Language (val id: String,val nameRes: Int) {
    THAI("THAILAND", R.string.language_thai),
    ENGLISH("ENGLISH",R.string.language_english);

    companion object {
        fun fromId(id: String) = values().associateBy(Language::id)[id]
    }
}