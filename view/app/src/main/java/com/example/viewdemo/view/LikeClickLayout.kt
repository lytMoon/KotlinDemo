package com.example.viewdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class LikeClickLayout @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attr, defStyleAttr) {
    //分别记录手指点击的位置坐标
    private var touchX = 0f
    private var touchY = 0f

    private val paint = Paint()
    private val mPoints = ArrayList<PointF>()

    init {
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                touchX = event.x
                touchY = event.y
                mPoints.add(PointF(touchX, touchY))
                invalidate()
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                touchX = event.x
                touchY = event.y
                mPoints.add(PointF(touchX, touchY))
                invalidate()
                return true
            }
        }
        //处理事件并刷新视图
        return true
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (mP in mPoints) {
            canvas.drawCircle(mP.x, mP.y, 15f, paint)
        }
    }

}