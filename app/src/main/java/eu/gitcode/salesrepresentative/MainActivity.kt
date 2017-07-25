package eu.gitcode.salesrepresentative

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigationListener()
    }

    private fun setupNavigationListener() {
        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_orders -> {
                    message.setText(R.string.orders)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_shops -> {
                    message.setText(R.string.shops)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_goods -> {
                    message.setText(R.string.goods)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notes -> {
                    message.setText(R.string.notes)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_timetable -> {
                    message.setText(R.string.timetable)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
