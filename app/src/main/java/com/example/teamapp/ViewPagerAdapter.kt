package com.example.teamapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class ViewPagerAdapter(
    fm: FragmentManager?,
    private val fragmentList: ArrayList<Fragment>,
    private val titleList: ArrayList<String>
) :
    FragmentPagerAdapter(fm!!) {
    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titleList[position]
    }

}