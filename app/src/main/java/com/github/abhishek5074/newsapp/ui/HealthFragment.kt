package com.github.abhishek5074.newsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.abhishek5074.newsapp.Adapter.NewsAdapter
import com.github.abhishek5074.newsapp.Model.Model
import com.github.abhishek5074.newsapp.Model.NewsModel
import com.github.abhishek5074.newsapp.Network.NewsApiService
import com.github.abhishek5074.newsapp.R
import com.github.abhishek5074.newsapp.Utils.Credentials
import com.github.abhishek5074.newsapp.databinding.FragmentHealthBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [HealthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HealthFragment : Fragment() {

    val item : ArrayList<NewsModel> = arrayListOf<NewsModel>()
    lateinit var mAdapter : NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentHealthBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_health,container,false)

        NewsApiService.newsApi.getCategoryNews(Credentials.API_KEY, "in", "health",100)
            .enqueue(object :
                Callback<Model> {
                override fun onResponse(call: Call<Model>, response: Response<Model>) {
                    item.addAll(response.body()!!.articles)
                        mAdapter = NewsAdapter(item)
                        binding.healthRecyclerView.adapter = mAdapter

                }

                override fun onFailure(call: Call<Model>, t: Throwable) {
                    Log.v("Response", "Result : " + t.message)
                }
            })

        binding.healthRecyclerView.layoutManager = LinearLayoutManager(this.activity)
        return binding.root
    }

}