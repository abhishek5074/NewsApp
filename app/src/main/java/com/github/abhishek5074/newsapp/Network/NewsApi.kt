package com.github.abhishek5074.newsapp.Network

import com.github.abhishek5074.newsapp.Model.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    fun getTopNews(@Query("apiKey") apiKey : String,
                        @Query("country")country : String,
    @Query("language") ln : String,
    @Query("pageSize") page:Int):Call<Model>

    @GET("top-headlines")
    fun getCategoryNews(@Query("apiKey") apiKey: String,
    @Query("country")country: String,
    @Query("category")category:String,
    @Query("pageSize")page: Int):Call<Model>


}