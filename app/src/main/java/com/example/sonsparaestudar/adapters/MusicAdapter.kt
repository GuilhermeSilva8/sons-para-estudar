package com.example.sonsparaestudar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sonsparaestudar.Music
import com.example.sonsparaestudar.R

class MusicAdapter(private var musicList : ArrayList<Music>) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    var onItemClick : ((Music) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val music = musicList[position]
        holder.imageView.setImageResource(music.image)
        holder.textView.text = music.title

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(music)
        }
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.ivMusicIcon)
        val textView: TextView = itemView.findViewById(R.id.tvMusicTitle)
    }
}