package com.hotdogcode.headlines.data.remote

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.hotdogcode.headlines.data.model.api.News
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NewsDataSource(
    private val newsApi:NewsApi,
    private val coroutineScope: CoroutineScope,
    private var job: Job?
) : PageKeyedDataSource<String, News>()
{
    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, News>
    ) {
        job = coroutineScope.launch {
//            val response = newsApi.getNewsList(1,params.requestedLoadSize)
            val response = newsApi.getTOITopStories("https://rss.app/feeds/jyF9Tely7o5QRS8A.xml")
            when{
                response.isSuccessful->{
//                    val newList = response.body()?.articles!!.filter {
//                        news ->  news.title.length>5
//                    }
//                    newList.forEach { Log.e("aslam",it.title) }
//                    callback.onResult(newList,
//                        null,
//                        2
//                    )
                    val newList = response.body()?.articles!!.filter {
                        it.title.length>5
                    }
                    callback.onResult(newList,
                        null,
                        "https://rss.app/feeds/jyF9Tely7o5QRS8A.xml"
                    )



                }
                else->{
                    Log.e("aslam","Load Initial ${response.message()}")
                }
            }
        }
    }


    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, News>) {
        job = coroutineScope.launch {
//            val response = newsApi.getNewsList(params.key,pageSize = params.requestedLoadSize)
//            when{
//                response.isSuccessful->{
//                    val newList = response.body()?.articles!!.filter {
//                            news ->  news.title.length>5
//                    }
//                    newList.forEach { Log.e("aslam",it.title) }
//                    callback.onResult(newList,
//                        params.key+1
//                    )
//                }
//                else->{
//                    Log.e("aslam","Load After ${response.message()}")
//                }
//            }


            val response = newsApi.getTOITopStories("https://rss.app/feeds/WDmVQmEtLr5pkRWl.xml")
            when{
                response.isSuccessful->{
//                    val newList = response.body()?.articles!!.filter {
//                        news ->  news.title.length>5
//                    }
//                    newList.forEach { Log.e("aslam",it.title) }
//                    callback.onResult(newList,
//                        null,
//                        2
//                    )
                    val newList = response.body()?.articles!!.filter {
                        it.title.length>5
                    }
                    callback.onResult(newList,
                        "https://rss.app/feeds/WDmVQmEtLr5pkRWl.xml"
                    )



                }
                else->{
                    Log.e("aslam","Load Initial ${response.message()}")
                }
            }

        }
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, News>) {
        TODO("Not yet implemented")
    }
}