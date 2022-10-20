package org.cn.github.data.encryption

import okhttp3.internal.and
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import kotlin.jvm.Throws

object AESHelper {

    private var ivParameterSpec: IvParameterSpec? = null
    private var secretKeySpec: SecretKeySpec? = null

    fun setKey(key: String, iv: String) {
        try {
            ivParameterSpec = IvParameterSpec(iv.toByteArray(charset("UTF-8")))
            secretKeySpec = SecretKeySpec(key.toByteArray(charset("UTF-8")), "AES")
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @Throws(Exception::class)
    fun encryptAES(encrypted: String, algorithm: String): String {
        val cipher = Cipher.getInstance(algorithm)
        cipher.init(
            Cipher.ENCRYPT_MODE,
            secretKeySpec,
            ivParameterSpec
        )
        return encodeHexString(cipher.doFinal(encrypted.toByteArray()))
    }

    @Throws(Exception::class)
    fun decryptAES(decrypted: String, algorithm: String): String {
        val cipher = Cipher.getInstance(algorithm)
        cipher.init(
            Cipher.DECRYPT_MODE,
            secretKeySpec,
            ivParameterSpec
        )
        return String(
            cipher.doFinal(
                decodeHexString(
                    decrypted
                )
            )
        )
    }

    @Throws(Exception::class)
    fun decodeHexString(hexText: String?): ByteArray? {
        if (hexText != null && hexText.isNotEmpty()) {
            val numBytes = hexText.length / 2
            val rawToByte = ByteArray(numBytes)
            var offset = 0
            for (i in 0 until numBytes) {
                val chunk = hexText.substring(offset, offset + 2)
                offset += 2
                rawToByte[i] = (Integer.parseInt(chunk, 16) and 0x000000FF).toByte()
            }
            return rawToByte
        }
        return null
    }

    private fun ByteArray.enCodeHexString() = joinToString("") { String.format("%02x", it) }

    private fun encodeHexString(rawData: ByteArray?): String {
        val hexText = StringBuilder()
        var initialHex: String? = null
        return if (rawData != null) {
            var initHexLength = 0
            var positiveValue = 0
            for (i in rawData.indices) {
                positiveValue = rawData[i] and 0x000000FF
                initialHex = Integer.toHexString(positiveValue)
                initHexLength = initialHex.length
                while (initHexLength++ < 2) {
                    hexText.append("0")
                }
                hexText.append(initialHex)
            }
            hexText.toString()
        } else {
            hexText.toString()
        }
    }
}