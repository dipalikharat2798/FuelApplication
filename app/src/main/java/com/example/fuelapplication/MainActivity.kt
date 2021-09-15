package com.example.fuelapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.ListFragment
import androidx.viewpager.widget.ViewPager
import com.example.fuelapplication.utility.FragmentAdapter
import com.example.fuelapplication.view.FuelListFragment
import com.example.fuelapplication.view.MapsFragment
import com.example.fuelapplication.view.RecentFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled=true
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        var viewPager = findViewById(R.id.viewpager) as ViewPager
        var tablayout = findViewById(R.id.tablayout) as TabLayout

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(MapsFragment(),"Maps")
        fragmentAdapter.addFragment(FuelListFragment(),"List")
        fragmentAdapter.addFragment(RecentFragment(),"Recent")

        viewPager.adapter = fragmentAdapter
        tablayout.setupWithViewPager(viewPager)

    }
}