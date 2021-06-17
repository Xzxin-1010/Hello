package com.example.teamapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MatchAdapter(private val context: Context, private val matchList:ArrayList<Match>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val matchTitle:TextView=view.findViewById(R.id.match_title)
        val matchImage:ImageView=view.findViewById(R.id.match_image)
        val matchEndTime:TextView=view.findViewById(R.id.match_endTime)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.match_item,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val match=matchList[position]
        Log.i("match",match.title)
        holder as ViewHolder
        holder.matchTitle.text=match.title
        holder.matchEndTime.text=match.endTime
        Glide.with(context).load(match.imageId).into(holder.matchImage)
    }
    override fun getItemCount()=matchList.size

}