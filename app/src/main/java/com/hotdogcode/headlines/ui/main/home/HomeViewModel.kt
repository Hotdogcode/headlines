package com.hotdogcode.headlines.ui.main.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.hotdogcode.factory.NewsDataSourceFactory
import com.hotdogcode.headlines.data.model.api.News
import com.hotdogcode.headlines.data.remote.NewsDataSource
import com.hotdogcode.headlines.data.remote.NewsService
import kotlinx.coroutines.*

class HomeViewModel :  ViewModel() {

    val newsList = MutableLiveData<List<News>>()
    val newsService = NewsService.getNewsService()
    val feedService = NewsService.getFeedService()



    var t : LiveData<PagedList<News>>

    val exceptionHandler= CoroutineExceptionHandler{
            coroutineContext, throwable ->  {}
    }

    val scope = CoroutineScope(Dispatchers.IO + exceptionHandler)
    var job: Job? = null


    init {
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setInitialLoadSizeHint(1)
            .setEnablePlaceholders(false)
            .build()
        t = initBuilder(config).build()
        //fetch2()
    }


    fun initBuilder(config: PagedList.Config): LivePagedListBuilder<String, News>
    {
//        val dataSourceFactory = object : DataSource.Factory<Int, News>(){
//            override fun create(): DataSource<Int, News> {
//                return NewsDataSource(newsService,scope,job)
//            }
//        }

        val dataSourceFactory2 = NewsDataSourceFactory(feedService,scope,job)

        return LivePagedListBuilder<String, News>(dataSourceFactory2,config)
    }

    fun fetch2(){
//        val job = CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
//            val response = feedService.getTOITopStories()
//            when{
//                response.isSuccessful->{
//                    val rss = response.body()
//                    rss?.items?.forEach {
//                        Log.e("aslam",it.title)
//                    }
//                }
//                else->{
//                    Log.e("aslam",response.message())
//                }
//            }
//        }
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