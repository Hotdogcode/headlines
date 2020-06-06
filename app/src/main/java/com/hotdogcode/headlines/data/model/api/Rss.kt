package com.hotdogcode.headlines.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


data class Rss(
    @Expose
    @SerializedName("items")
    val items:List<Item>
)
data class Item(
    @Expose
    @SerializedName("title")
    val title:String
)
