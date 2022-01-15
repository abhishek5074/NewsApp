package com.github.abhishek5074.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.github.abhishek5074.newsapp.R
import com.github.abhishek5074.newsapp.databinding.ActivityNewsArticleBinding

class NewsArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityNewsArticleBinding = DataBindingUtil.setContentView(this,R.layout.activity_news_article)


        val url:String = intent.getStringExtra("url")!!
        binding.webview.loadUrl(url)

    }
}