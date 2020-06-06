package com.hotdogcode.headlines.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Response(
    @Expose
    @SerializedName("items")
    val articles:List<News>,

    @Expose
    @SerializedName("status")
    val status:String,

    @Expose
    @SerializedName("totalResults")
    val totalResults:Int
){
    override fun toString(): String {
        return "$articles -> $status -> $totalResults"
    }
}