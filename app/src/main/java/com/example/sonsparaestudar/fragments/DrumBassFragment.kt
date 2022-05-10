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
import com.example.sonsparaestudar.databinding.FragmentDrumBassBinding

class DrumBassFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var musicList: ArrayList<Music>
    private lateinit var musicAdapter: MusicAdapter
    private lateinit var binding : FragmentDrumBassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_drum_bass, container, false)
        binding = FragmentDrumBassBinding.inflate(layoutInflater, container, false)

        val view = binding.root

        recyclerView = binding.rvMusics

        musicList = ArrayList()
        musicList.add(Music(R.drawable.ic_drum_bass, "Fight Till The End", R.raw.db_fighttilltheend))
        musicList.add(Music(R.drawable.ic_drum_bass, "Machine Drum Vibes", R.raw.db_machinedrumvibes))
        musicList.add(Music(R.drawable.ic_drum_bass, "Pianinni", R.raw.db_pianinni))
        musicList.add(Music(R.drawable.ic_drum_bass, "Trapanomics", R.raw.db_trapanomics))
        musicList.add(Music(R.drawable.ic_drum_bass, "Up Work All My Life", R.raw.db_upworkallmylife))

        musicAdapter = MusicAdapter(musicList)
        recyclerView.adapter = musicAdapter

        musicAdapter.onItemClick = {
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("music", it)
            intent.putExtra("tab", 1)
            activity?.finish()  //Kill the activity from which you will go to next activity
            startActivity(intent)
        }

        return view
    }
}