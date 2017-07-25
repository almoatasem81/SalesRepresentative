package eu.gitcode.salesrepresentative.feature.main

import ClientProfilePagesEnum
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import eu.gitcode.salesrepresentative.R
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MainFragmentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupNavigationListener()
        setUpViewPager()
    }

    private fun setupNavigationListener() {
        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_orders -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_shops -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_goods -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notes -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_timetable -> {
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun setUpViewPager() {
        adapter = MainFragmentsAdapter(supportFragmentManager)
        viewPager.swipeable = false
        viewPager.adapter = adapter
        viewPager.currentItem = ClientProfilePagesEnum.ORDERS.ordinal
        viewPager.offscreenPageLimit = MainFragmentsAdapter.PAGE_COUNT
    }
}
