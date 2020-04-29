package com.example.myviewpager1

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class MyChildViewPager : ViewPager {
    private var downX: Float = 0f
    private var flag: Boolean = false //
    val TAG = "MyChildViewPager"

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}
        //用内部拦截法
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val action: Int = ev.action
        when (action) {
            MotionEvent.ACTION_DOWN -> {
                downX = ev.x
                flag = true
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                if (flag) {
                    val count: Int = adapter!!.count
                    val currPosition: Int = currentItem
                    if (currPosition == count - 1 && ev.x - downX < 0) { //最后一页，并且向左滑动
                        parent.requestDisallowInterceptTouchEvent(false)
                        Log.d(TAG,"最后一页，并且向左滑动")

                    } else if (currPosition == 0 && ev.x - downX > 0) {  //第一页，并且向右滑动
                        parent.requestDisallowInterceptTouchEvent(false)
                        Log.d(TAG,"第一页，并且向右滑动")
                    }
                    else {
                        parent.requestDisallowInterceptTouchEvent(true)
                        Log.d(TAG,"最后一个分支")
                    }
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}