package app.com.milico.base

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
        @SerializedName("message") val message: String,
        @SerializedName("results") val results: T?
)