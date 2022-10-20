package org.cn.github.data.model

import com.google.gson.annotations.SerializedName

data class ResponseStatusEntity(
    @SerializedName("code")
    val code: String = "",
    @SerializedName("message")
    val message: String = "",
    @SerializedName("messageType")
    val messageType: String = "",
    @SerializedName("operation")
    val operation: String = "",
    @SerializedName("status")
    val status: String = ""
)