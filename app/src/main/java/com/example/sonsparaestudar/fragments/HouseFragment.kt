package com.example.sonsparaestudar.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sonsparaestudar.MainActivity
import com.example.sonsparaestudar.Music
import com.example.sonsparaestudar.R
import com.example.sonsparaestudar.adapters.MusicAdapter
import com.example.sonsparaestudar.databinding.FragmentHouseBinding

class HouseFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var musicList: ArrayList<Music>
    private lateinit var musicAdapter: MusicAdapter
    private lateinit var binding : FragmentHouseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_house, container, false)
        binding = FragmentHouseBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        recyclerView = binding.rvMusics

        musicList = ArrayList()
        musicList.add(Music(R.drawable.ic_house, "Alright", R.raw.house_alright))
        musicList.add(Music(R.drawable.ic_house, "Aquella Tarde En Yelapa", R.raw.house_aquellatardeenyelapa))
        musicList.add(Music(R.drawable.ic_house, "Closer", R.raw.house_closer))
        musicList.add(Music(R.drawable.ic_house, "Crumpled Letters", R.raw.house_crumpledletters))
        musicList.add(Music(R.drawable.ic_house, "Digital Clouds", R.raw.house_digitalclouds))
        musicList.add(Music(R.drawable.ic_house, "Hazy After Hours", R.raw.house_hazyafterhours))
        musicList.add(Music(R.drawable.ic_house, "Sleepy Cat", R.raw.house_sleepycat))
        musicList.add(Music(R.drawable.ic_house, "Space Game", R.raw.house_spacegame))
        musicList.add(Music(R.drawable.ic_house, "Workout 01", R.raw.house_workout01))

        musicAdapter = MusicAdapter(musicList)
        recyclerView.adapter = musicAdapter

        musicAdapter.onItemClick = {
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("music", it)
            intent.putExtra("tab", 3)
            startActivity(intent)
        }

        return view
    }
}