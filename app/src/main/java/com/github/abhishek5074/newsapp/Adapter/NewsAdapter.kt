package com.github.abhishek5074.newsapp.Adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.abhishek5074.newsapp.Model.NewsModel
import com.github.abhishek5074.newsapp.R
import com.github.abhishek5074.newsapp.ui.NewsArticleActivity

class NewsAdapter(private val items: ArrayList<NewsModel>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {



    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val headline: TextView = itemView.findViewById(R.id.headline)
        val time:TextView = itemView.findViewById(R.id.publishedAt)
        val source:TextView = itemView.findViewById(R.id.author)
        val image = itemView.findViewById<ImageView>(R.id.imageView)
        val item : CardView = itemView.findViewById(R.id.newsArticle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        Log.v("Response",items.toString())
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.headline.text = currentItem.title
        holder.source.text = currentItem.source.name
        holder.time.text = currentItem.publishedAt!!.subSequence(0,10)
        Glide
            .with(holder.itemView.context)
            .load(currentItem.urlToImage)
            .into(holder.image)

        holder.item.setOnClickListener {
            val intent = Intent(holder.item.context, NewsArticleActivity::class.java)
            intent.putExtra("url",items[position].url)
            holder.item.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}