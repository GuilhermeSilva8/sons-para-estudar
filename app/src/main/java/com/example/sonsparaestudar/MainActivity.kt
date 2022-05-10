package com.example.sonsparaestudar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.sonsparaestudar.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tlAbas)
        val viewPager2 = findViewById<ViewPager2>(R.id.vpFragments)
        val vpAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        viewPager2.adapter = vpAdapter
        TabLayoutMediator(tabLayout, viewPager2) {tab, position ->
            when(position) {
                0 -> {
                    tab.text = "Ambient"
                }
                1 -> {
                    tab.text = "Drum & Bass"
                }
                2 -> {
                    tab.text = "Experimental"
                }
                3 -> {
                    tab.text = "House"
                }
                4 -> {
                    tab.text = "Pop"
                }
                5 -> {
                    tab.text = "R&B"
                }
                6 -> {
                    tab.text = "Trap/Hip-Hop"
                }
            }
        }.attach()

        val music = intent.getParcelableExtra<Music>("music")
        val tab = intent.getIntExtra("tab", 0)
        tabLayout.getTabAt(tab)?.select()
        Toast.makeText(this, "Selected ${music?.title} from tab $tab", Toast.LENGTH_SHORT).show()

        if(music != null) {
            //controlSound(music.song)
        }
    }

    override fun onStop() {
        super.onStop()

    }
}