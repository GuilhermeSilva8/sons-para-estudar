package com.example.sonsparaestudar

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.sonsparaestudar.adapters.ViewPagerAdapter
import com.example.sonsparaestudar.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mp: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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

        if(music != null) {
            controlSound(music.song)
        }
    }

    private fun controlSound(id: Int) {
        var isPlaying = true
        binding.fabPlayPause.setImageResource(R.drawable.ic_pause)

        if(mp !== null) {
            mp?.stop()
            mp?.reset()
            mp?.release()
            mp = null
        }

        mp = MediaPlayer.create(this, id)
        initialiseSeekBar()
        mp?.start()

        binding.fabPlayPause.setOnClickListener {
            if(isPlaying) {
                if(mp !== null) mp?.pause()
                binding.fabPlayPause.setImageResource(R.drawable.ic_play)
                isPlaying = false
            } else {
                mp?.start()
                binding.fabPlayPause.setImageResource(R.drawable.ic_pause)
                isPlaying = true
            }
        }

        binding.sbTime.setOnSeekBarChangeListener(@SuppressLint("AppCompatCustomView")
        object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) mp?.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    private fun initialiseSeekBar() {
        binding.sbTime.max = mp!!.duration

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object: Runnable{
            override fun run() {
                try {
                    binding.sbTime.progress = mp!!.currentPosition
                    handler.postDelayed(this, 1000)
                } catch (e: Exception) {
                    binding.sbTime.progress = 0
                }
            }
        }, 0)
    }

    override fun onStop() {
        super.onStop()

        mp?.stop()
        mp?.reset()
        mp?.release()
        mp = null
    }
}