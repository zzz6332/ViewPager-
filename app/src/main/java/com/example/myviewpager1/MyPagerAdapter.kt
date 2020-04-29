package com.example.myviewpager1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(fm: FragmentManager, behavior: Int,fraList: List<Fragment>) : FragmentPagerAdapter(fm, behavior) {
    val frm = fraList
    override fun getItem(position: Int): Fragment = frm[position]

    override fun getCount(): Int = frm.size

    override fun getPageTitle(position: Int): CharSequence =  "$position"
}
