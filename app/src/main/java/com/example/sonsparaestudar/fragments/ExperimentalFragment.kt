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
import com.example.sonsparaestudar.databinding.FragmentExperimentalBinding

class ExperimentalFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var musicList: ArrayList<Music>
    private lateinit var musicAdapter: MusicAdapter
    private lateinit var binding : FragmentExperimentalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_experimental, container, false)
        binding = FragmentExperimentalBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        recyclerView = binding.rvMusics

        musicList = ArrayList()
        musicList.add(Music(R.drawable.ic_experimental, "Acid Party", R.raw.experimental_acidparty))
        musicList.add(Music(R.drawable.ic_experimental, "Allure", R.raw.experimental_allure))
        musicList.add(Music(R.drawable.ic_experimental, "I've Been Careful", R.raw.experimental_ivebeencareful))
        musicList.add(Music(R.drawable.ic_experimental, "Pop 11", R.raw.experimental_pop11))

        musicAdapter = MusicAdapter(musicList)
        recyclerView.adapter = musicAdapter

        musicAdapter.onItemClick = {
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("music", it)
            intent.putExtra("tab", 2)
            intent.putParcelableArrayListExtra("musics", musicList)
            activity?.finish()  //Kill the activity from which you will go to next activity
            startActivity(intent)
        }

        return view
    }
}