package com.hotdogcode.headlines.data.remote

import com.hotdogcode.headlines.data.model.api.Response
import io.reactivex.Single

interface ApiHelper {

    suspend fun getNewsList():Response
}