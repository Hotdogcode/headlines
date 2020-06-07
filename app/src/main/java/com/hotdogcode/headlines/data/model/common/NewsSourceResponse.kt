package com.hotdogcode.headlines.data.model.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsSourceResponse(
    @Expose
    @SerializedName("sources")
    val sourceList:List<NewsSource>
)