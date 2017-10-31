package eu.gitcode.salesrepresentative.common.extension

import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment

inline fun <reified T : Activity> Fragment.startActivityForResult(resultCode: Int) {
    val intent = Intent(context, T::class.java)
    startActivityForResult(intent, resultCode)
}

fun Fragment.setResult(resultCode: Int) {
    this.activity.setResult(resultCode)
}

fun Fragment.finish() {
    this.activity.finish()
}