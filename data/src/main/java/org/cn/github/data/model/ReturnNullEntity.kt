package org.cn.github.data.model

import com.google.gson.annotations.SerializedName

data class ReturnNullEntity(
    @SerializedName("responseStatus")
    var responseStatusEntity: ResponseStatusEntity,
    @SerializedName("result")
    var result: Any?
)