package org.cn.github.data.encryption

import org.cn.github.domain.extension.sha256
import java.util.*

object AESEncryption {

    private const val iv = "CS5FN19Q1J5VXX67"

    private fun encryptionAES(value: String?, secretKey: String?): String {
        AESHelper.setKey(
            secretKey ?: "",
            iv
        )
        return if (!value.isNullOrEmpty()) {
            AESHelper.encryptAES(
                value,
                "AES/CBC/PKCS7Padding"
            )
        } else {
            ""
        }
    }

    private fun decryptionAES(value: String?, secretKey: String): String {
        AESHelper.setKey(
            secretKey,
            iv
        )
        return if (!value.isNullOrEmpty()) {
            AESHelper.decryptAES(
                value,
                "AES/CBC/PKCS7Padding"
            )
        } else {
            ""
        }
    }

    fun encryptSting(r1: String, r2: String, text: String): String {
        return if (text.isNullOrEmpty()) {
            ""
        } else {
            var r3 = (r1 + r2).sha256()
            try {
                encryptionAES(text, r3)
            } catch (e: Exception) {
                text
            }
        }

    }

    fun decryptSting(r1: String, r2: String, text: String?): String {
        return if (text.isNullOrEmpty())
            ""
        else {
            var r3 = (r1 + r2).sha256()
            try {
                decryptionAES(text, r3)
            } catch (e: Exception) {
                text
            }
        }
    }

    fun generateR1(): String {
        return UUID.randomUUID().toString().sha256()
    }
}