package com.example.myviewpager1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fms = listOf<Fragment>(OuterFragment(),OuterFragment(),OuterFragment(),OuterFragment(),OuterFragment())
        val vp = findViewById<ViewPager>(R.id.vp_main)
        val tl = findViewById<TabLayout>(R.id.tab_main)
        val adapter = MyPagerAdapter(supportFragmentManager,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fms)
        vp.adapter = adapter
        tl.setupWithViewPager(vp)
    }
}
