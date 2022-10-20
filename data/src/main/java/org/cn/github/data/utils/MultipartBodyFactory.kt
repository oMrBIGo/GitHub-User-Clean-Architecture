package org.cn.github.data.utils

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import org.cn.github.common.ui.util.FileFactory
import java.io.File

object MultipartBodyFactory {

    fun createFromData(key: String, file: File?) : MultipartBody.Part? {
        return file?.let {
            val mediaType = FileFactory.getMimeType(file)?.toMediaTypeOrNull()
            val reqFile = it.asRequestBody(mediaType)
            MultipartBody.Part.createFormData(key, it.name, reqFile)
        }
    }

    fun createFromData(key: String, files: List<File?>?) : List<MultipartBody.Part?>? {
        files?.let { file ->
            val results = ArrayList<MultipartBody.Part?>()
            file.map { data ->
                data?.let {
                    val mediaType = FileFactory.getMimeType(it)?.toMediaTypeOrNull()
                    val reqFile = it.asRequestBody(mediaType)
                    results.add(MultipartBody.Part.createFormData(key, it.name,reqFile))
                }
            }
            return results
        }
        return null
    }

    fun createFromData(key: String, value: String?): MultipartBody.Part? {
        return value?.let {
            MultipartBody.Part.createFormData(key, value)
        }
    }

    fun createFromData(key: String, value: List<String?>?): ArrayList<MultipartBody.Part?>? {
        value?.let {
            val results = ArrayList<MultipartBody.Part?>()
            it.map { data ->
                data?.let {
                    results.add(MultipartBody.Part.createFormData(key, data))
                }
            }
            return results
        }
        return null
    }
}