package com.example.viewdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * 这里画一个圆
 */
class CircleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    //生成画笔
    private val paint = Paint()

    //设置画笔参数
    init {
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        Log.d("998489344", "onDraw: ")
        super.onDraw(canvas)
        val width = width
        val height = height
        Log.d("99990", "onDraw: $width  $height ")
        val radius = width.coerceAtMost(height) / 2.toFloat()
        val centerX = width / 2
        val centerY = height / 2
        canvas.drawCircle(centerX.toFloat(), centerY.toFloat(), radius, paint)
    }
}