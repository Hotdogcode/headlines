package com.hotdogcode.headlines.data.remote

import com.hotdogcode.headlines.utils.BASE_URL
import com.hotdogcode.headlines.utils.BASE_URL_TOI_FEED
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object NewsService {
    fun getNewsService():NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    fun getFeedService():NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL_TOI_FEED)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }
}