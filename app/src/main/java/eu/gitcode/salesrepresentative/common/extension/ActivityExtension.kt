package eu.gitcode.salesrepresentative.common.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

inline fun <reified T : Activity> Context.startActivity() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}

inline fun <reified T : Activity> Activity.startActivityForResult(resultCode: Int) {
    val intent = Intent(this, T::class.java)
    startActivityForResult(intent, resultCode)
}

fun AppCompatActivity.replaceFragment(containerViewId: Int, fragment: Fragment)
        : FragmentTransaction {
    val fragmentTransaction = supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(containerViewId, fragment)
    return fragmentTransaction
}