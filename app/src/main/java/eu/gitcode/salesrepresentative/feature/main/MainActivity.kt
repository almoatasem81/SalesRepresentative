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
                    viewPager.currentItem = ClientProfilePagesEnum.ORDERS.ordinal
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_shops -> {
                    viewPager.currentItem = ClientProfilePagesEnum.SHOPS.ordinal
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_goods -> {
                    viewPager.currentItem = ClientProfilePagesEnum.GOODS.ordinal
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notes -> {
                    viewPager.currentItem = ClientProfilePagesEnum.NOTES.ordinal
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_timetable -> {
                    viewPager.currentItem = ClientProfilePagesEnum.TIMETABLE.ordinal
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
