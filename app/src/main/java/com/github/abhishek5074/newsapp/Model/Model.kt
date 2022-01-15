package com.github.abhishek5074.newsapp.Model

data class Model(
    val articles : ArrayList<NewsModel>
)

data class NewsModel(
    val source: source,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?)

data class source (
    val name : String
        )
