package com.hotdogcode.headlines.ui.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.hotdogcode.headlines.data.model.api.News
import com.hotdogcode.headlines.data.remote.NewsDataSource
import com.hotdogcode.headlines.data.remote.NewsService
import kotlinx.coroutines.*

class SplashViewModel:ViewModel() {

    val newsList = MutableLiveData<List<News>>()
    val newsService = NewsService.getNewsService()



    var t :LiveData<PagedList<News>>

    val exceptionHandler=CoroutineExceptionHandler{
        coroutineContext, throwable ->  {}
    }

    val scope = CoroutineScope(Dispatchers.IO + exceptionHandler)
    var job:Job? = null


    init{
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setInitialLoadSizeHint(1)
            .setEnablePlaceholders(false)
            .build()
        t = initBuilder(config).build()
    }

    fun initBuilder(config:PagedList.Config):LivePagedListBuilder<String,News>
    {
        val dataSourceFactory = object : DataSource.Factory<String,News>(){
            override fun create(): DataSource<String, News> {
                return NewsDataSource(newsService,scope,job)
            }
        }
        return LivePagedListBuilder<String,News>(dataSourceFactory,config)
    }


    fun fetch(){
//        job = CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
//            val response = newsService.getNewsList()
//            withContext(Dispatchers.Main){
//                when{
//                    response.isSuccessful->{
//                        val data = response.body()
//                        newsList.value = data?.articles
//                    }
//                    else->{
//                        Log.e("aslam","Error ${response.message()}")
//                    }
//
//                }
//            }
//        }



    }

}