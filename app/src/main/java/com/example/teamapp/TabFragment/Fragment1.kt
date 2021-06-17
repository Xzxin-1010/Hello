package com.example.teamapp.TabFragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamapp.Match
import com.example.teamapp.MatchAdapter
import com.example.teamapp.R

class Fragment1(private val title: String) : Fragment() {
    private lateinit var mTitle:String
    private val matchList=ArrayList<Match>()
    lateinit var matchAdapter: MatchAdapter
    lateinit var fcontext:Context
    lateinit var fraRecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View= inflater.inflate(R.layout.fragment_tab,container,false)
        mTitle=title
        fcontext=view.context
        fraRecyclerView=view.findViewById(R.id.match_recyclerView)
        initRecyclerView()
        return view
    }
    private fun initRecyclerView(){
        repeat(10){
            matchList.add(Match("2021华为区块链高校大赛",
                R.drawable.match5,"截止时间：2021年6月14号"))
        }
        matchAdapter= MatchAdapter(fcontext,matchList)
        val layoutManager=LinearLayoutManager(fcontext)
        layoutManager.orientation=LinearLayoutManager.VERTICAL
        fraRecyclerView.layoutManager=layoutManager
        fraRecyclerView.adapter=matchAdapter
        Log.i("matchList",matchList.size.toString())
    }
}