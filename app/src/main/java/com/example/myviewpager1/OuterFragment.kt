package com.example.myviewpager1

import android.os.Bundle
import android.support.v4.app.INotificationSideChannel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class OuterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_outer,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       val vp = view.findViewById<ViewPager>(R.id.vp_fragment_outer)
        val tl = view.findViewById<TabLayout>(R.id.tab_fragment_outer)
        val fms = listOf<Fragment>(InnerFragment(),InnerFragment(),InnerFragment(),InnerFragment(),InnerFragment())
        val adapter = MyPagerAdapter(childFragmentManager,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fms)
        vp.adapter = adapter
        tl.setupWithViewPager(vp)
    }
}