package com.hotdogcode.headlines.data.remote

import com.hotdogcode.headlines.data.model.api.Rss
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {
    @GET("everything?q=corona&apiKey=1ebe6f9f41a44e398a4f0ab1916ce831")
    suspend fun getNewsList(@Query("page") page:Int, @Query("pageSize") pageSize:Int):
            Response<com.hotdogcode.headlines.data.model.api.Response>


    @GET("api.json?")
    suspend fun getTOITopStories(@Query("rss_url") url:String):Response<com.hotdogcode.headlines.data.model.api.Response>

}