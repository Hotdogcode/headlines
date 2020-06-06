package com.hotdogcode.headlines.adapters

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hotdogcode.headlines.R
import com.hotdogcode.headlines.data.model.api.News
import kotlinx.android.synthetic.main.news_list_row.view.*
import org.jsoup.Jsoup

class NewsListAdapter:PagedListAdapter<News,NewsListAdapter.NewsViewHolder>(DiffUtilCallBack()) {

    fun updateData(data:List<News>){
//        newsList.clear()
//        newsList.addAll(data)
//        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_list_row,parent,false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       getItem(position)?.let { holder.bind(it) }
    }


    class NewsViewHolder(view:View):RecyclerView.ViewHolder(view){
        private val title = view.title
        private val image = view.image
        fun bind(news:News){
            title.text = news.title
            var imgLink:String?=null
            news.description?.let {
                Log.e("aslam",it)
                val e = Jsoup.parse(it).select("img")
                imgLink = e?.attr("src")
                Log.e("aslam",e.`val`())

                imgLink?.let {
                    link->Glide.with(itemView)
                        .load(link)
                        .centerCrop()
                        .into(image)
                }
            }


        }

    }


}
class DiffUtilCallBack : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.title == newItem.title
    }

}
