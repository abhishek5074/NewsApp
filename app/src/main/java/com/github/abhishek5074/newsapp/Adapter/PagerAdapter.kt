package com.github.abhishek5074.newsapp.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.abhishek5074.newsapp.ui.BusinessFragment
import com.github.abhishek5074.newsapp.ui.*

class PagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int {
        return 7
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> SportsFragment()
            2 -> BusinessFragment()
            3 -> ScienceFragment()
            4 -> TechnologyFragment()
            5 -> EntertainmentFragment()
            6 -> HealthFragment()
            else -> HomeFragment()
        }
    }

}