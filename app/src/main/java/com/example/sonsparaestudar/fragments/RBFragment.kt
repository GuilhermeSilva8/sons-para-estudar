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
import com.example.sonsparaestudar.databinding.FragmentRBBinding

class RBFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var musicList: ArrayList<Music>
    private lateinit var musicAdapter: MusicAdapter
    private lateinit var binding : FragmentRBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_r_b, container, false)
        binding = FragmentRBBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        recyclerView = binding.rvMusics

        musicList = ArrayList()
        musicList.add(Music(R.drawable.ic_pop, "Alter Ego", R.raw.rb_alterego))
        musicList.add(Music(R.drawable.ic_pop, "Green Chair", R.raw.rb_greenchair))
        musicList.add(Music(R.drawable.ic_pop, "Majestic", R.raw.rb_majestic))
        musicList.add(Music(R.drawable.ic_pop, "RnB", R.raw.rb_rnb))
        musicList.add(Music(R.drawable.ic_pop, "Vampire", R.raw.rb_vampire))

        musicAdapter = MusicAdapter(musicList)
        recyclerView.adapter = musicAdapter

        musicAdapter.onItemClick = {
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("music", it)
            intent.putExtra("tab", 5)
            intent.putParcelableArrayListExtra("musics", musicList)
            activity?.finish()  //Kill the activity from which you will go to next activity
            startActivity(intent)
        }

        return view
    }
}