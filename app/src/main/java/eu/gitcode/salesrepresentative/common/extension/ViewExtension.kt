package eu.gitcode.salesrepresentative.common.extension

import android.widget.EditText

fun EditText.string(): String {
    return this.text.toString()
}