package com.example.sonsparaestudar.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sonsparaestudar.fragments.*

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 7
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                AmbientFragment()
            }
            1 -> {
                DrumBassFragment()
            }
            2 -> {
                ExperimentalFragment()
            }
            3 -> {
                HouseFragment()
            }
            4 -> {
                PopFragment()
            }
            5 -> {
                RBFragment()
            }
            6 -> {
                TrapHipHopFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}