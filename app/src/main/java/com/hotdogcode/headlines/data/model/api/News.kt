package com.hotdogcode.headlines.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class News(


    @Expose
    @SerializedName("title")
    val title:String,

    @Expose
    @SerializedName("content_html")
    val contentHtml:String,

    @Expose
    @SerializedName("source")
    val source:Source,

    @Expose
    @SerializedName("description")
    val description:String,

    @Expose
    @SerializedName("url")
    val url:String,

    @Expose
    @SerializedName("urlToImage")
    val urlToImage:String,

    @Expose
    @SerializedName("publishedAt")
    val publishedAt:String,

    @Expose
    @SerializedName("content")
    val content:String
){
    override fun toString(): String {
        return "$title -> $description -> $url -> $urlToImage -> $publishedAt -> $content"
    }
}