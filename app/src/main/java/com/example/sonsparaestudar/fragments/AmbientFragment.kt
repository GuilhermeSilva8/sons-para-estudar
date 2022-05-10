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
import com.example.sonsparaestudar.databinding.FragmentAmbientBinding

class AmbientFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var musicList: ArrayList<Music>
    private lateinit var musicAdapter: MusicAdapter
    private lateinit var binding : FragmentAmbientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_ambient, container, false)
        binding = FragmentAmbientBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        recyclerView = binding.rvMusics

        musicList = ArrayList()
        musicList.add(Music(R.drawable.ic_ambient, "LoFi 02", R.raw.ambient_lofi02))
        musicList.add(Music(R.drawable.ic_ambient, "LoFi 04", R.raw.ambient_lofi04))
        musicList.add(Music(R.drawable.ic_ambient, "Yoga Music 04", R.raw.ambient_yogamusic04))
        musicList.add(Music(R.drawable.ic_ambient, "Yoga Music 05", R.raw.ambient_yogamusic05))

        musicAdapter = MusicAdapter(musicList)
        recyclerView.adapter = musicAdapter

        musicAdapter.onItemClick = {
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("music", it)
            intent.putExtra("tab", 0)
            startActivity(intent)
        }

        return view
    }
}