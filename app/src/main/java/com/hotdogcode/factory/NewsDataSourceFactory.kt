package com.hotdogcode.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.hotdogcode.headlines.data.model.api.News
import com.hotdogcode.headlines.data.remote.NewsApi
import com.hotdogcode.headlines.data.remote.NewsDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

class NewsDataSourceFactory(
    private val newsApi: NewsApi,
    private val coroutineScope: CoroutineScope,
    private var job: Job?
):DataSource.Factory<String,News> ()
{

    val newsDataSourceLiveData = MutableLiveData<NewsDataSource>()
    override fun create(): DataSource<String, News> {
        val newsDataSource = NewsDataSource(newsApi, coroutineScope, job)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}