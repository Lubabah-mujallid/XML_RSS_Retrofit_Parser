package com.example.xml_rss_retrofit_parser

import retrofit2.http.GET
import com.example.xml_rss_retrofit_parser.channel.Rss
import retrofit2.Call

interface FeedAPI {
    @get:GET("Travel.xml")
    val feed: Call<Rss?>?

    companion object {
        const val BASE_URL = "https://rss.nytimes.com/services/xml/rss/nyt/"
    }
}