package com.hotdogcode.headlines.data.model.common

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


//this model is common between api and room

@Entity(tableName = "news_sources")
class NewsSource(
    @Expose
    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name:String,


    @Expose
    @SerializedName("source")
    @ColumnInfo(name="source")
    val source:String
){

    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}