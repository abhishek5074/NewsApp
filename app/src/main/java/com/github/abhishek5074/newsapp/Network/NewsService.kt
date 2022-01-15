package com.github.abhishek5074.newsapp.Network

import com.github.abhishek5074.newsapp.Network.NewsApi
import com.github.abhishek5074.newsapp.Utils.Credentials
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//Singleton Pattern
object NewsApiService {

    private val retrofit by lazy {   Retrofit.Builder()
        .baseUrl(Credentials.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }
    val newsApi by lazy {
        retrofit.create(NewsApi::class.java)
    }
}
