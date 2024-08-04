package view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent

/**
 *  author : lytMoon
 *  email : yytds@foxmail.com
 *  date: 2024/8/4 13:57
 *  version : 1.0
 *  description :
 *  saying : 这世界天才那么多，也不缺我一个
 */
class MyButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatButton(context, attrs, defStyleAttr) {



    init {
        test()
    }

    private fun test() {
        setBackgroundColor(Color.BLUE)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

        when (ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d("6666666", "第一个响应了ACTION_DOWN")
            }

            MotionEvent.ACTION_MOVE -> {
                Log.d("6666666", "第一个响应了ACTION_MOVE")

            }

            MotionEvent.ACTION_UP -> {
                Log.d("6666666", "第一个响应了ACTION_UP")

            }
            MotionEvent.ACTION_CANCEL -> {
                Log.d("6666666", "第一个响应了ACTION_CANCEL")

            }
        }


        return super.dispatchTouchEvent(ev)
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }

}