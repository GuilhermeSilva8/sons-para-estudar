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
import com.example.sonsparaestudar.databinding.FragmentTrapHipHopBinding

class TrapHipHopFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var musicList: ArrayList<Music>
    private lateinit var musicAdapter: MusicAdapter
    private lateinit var binding : FragmentTrapHipHopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_trap_hip_hop, container, false)
        binding = FragmentTrapHipHopBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        recyclerView = binding.rvMusics

        musicList = ArrayList()
        musicList.add(Music(R.drawable.ic_trap, "CBPD", R.raw.hh_cbpd))
        musicList.add(Music(R.drawable.ic_trap, "Grinding Hard", R.raw.trap_grindinghard))
        musicList.add(Music(R.drawable.ic_trap, "HK", R.raw.trap_hk))
        musicList.add(Music(R.drawable.ic_trap, "Nav Type", R.raw.trap_navtype))

        musicAdapter = MusicAdapter(musicList)
        recyclerView.adapter = musicAdapter

        musicAdapter.onItemClick = {
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("music", it)
            intent.putExtra("tab", 6)
            startActivity(intent)
        }

        return view
    }
}