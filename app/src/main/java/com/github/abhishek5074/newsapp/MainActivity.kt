package com.github.abhishek5074.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.github.abhishek5074.newsapp.databinding.ActivityMainBinding
import com.github.abhishek5074.newsapp.Adapter.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        val viewPager = findViewById<ViewPager2>(R.id.fragementViewPager)
        val adapter = PagerAdapter(supportFragmentManager,lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) {
                tab,position->
            when(position) {
                0 -> tab.text="Home"
                1 -> tab.text="Sports"
                2 -> tab.text="Business"
                3 -> tab.text="Science"
                4 -> tab.text="Technology"
                5 -> tab.text="Entertainment"
                6 ->tab.text="Health"
            }
        }.attach()

    }
}