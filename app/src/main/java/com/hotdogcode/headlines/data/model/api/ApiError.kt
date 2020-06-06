package com.hotdogcode.headlines.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiError(
    @Expose
    @SerializedName("status")
    val status:String,

    @Expose
    @SerializedName("code")
    val code:String,

    @Expose
    @SerializedName("message")
    val message:String
){
    override fun toString(): String {
        return "$status -> $code -> $message"
    }
}