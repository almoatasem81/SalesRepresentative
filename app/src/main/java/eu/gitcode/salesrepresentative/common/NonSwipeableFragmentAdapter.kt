package eu.gitcode.salesrepresentative.common

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent


class LockableViewPager : ViewPager {
    var swipeable: Boolean = false

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.swipeable = true
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (this.swipeable) {
            return super.onTouchEvent(event)
        }
        return false
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        if (this.swipeable) {
            return super.onInterceptTouchEvent(event)
        }
        return false
    }
}