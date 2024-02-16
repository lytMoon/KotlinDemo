package view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout

/**
 * 这里用来研究事件分发机制
 * 事件分发机制的简单伪代码逻辑如下
 *
 * public boolean dispatchTouchEvent(MotionEvent ev) {
 *      boolean consume = false;
 *      if (onInterceptTouchEvent(ev)) {
 *      consume = onTouchEvent(ev);}
 *      else {
 *      consume = child.dispatchTouchEvent(ev);
 *      }
 *      return consume;
 * }
 *   在最先执行的dispatchTouchEvent中根据onInterceptTouchEvent(ev)来判断是否拦截事件，如果返回true则代表拦截事件，交给该view的OnTouchEvent
 *   处理，如果不拦截则交给子view的dispatchTouchEvent()事件里面。如此反复直到事件被最终处理。
 *
 *   优先级顺序：
 *   onTouchListener>OnTouchEvent>OnClickListener
 *   如果一个View的onTouchEvent返回false，那么它的父容器
 *   onTouchEvent将会被调用，依此类推。如果所有的元素都不处理这个事件，那么这个事件将会最终传递给Activity处理
 *   这里就好比上层领导把任务交给了下层的程序员，程序员拦截了事件但是没有消费处理，这是会由上层领导来进行处理，层层类推
 *
 *   三大事件
 *   down  move up 分别对应手指触碰 移动 抬起
 *   down 找到拦截的view
 *   一些规律
 *
 *    1正常情况下，一个事件序列只能被一个View拦截且消耗
 *
 *    2某个View一旦决定拦截，那么这一个事件序列都只能由它来处理（如果事件序列能够传递给它的话），并且它的onInterceptTouchEvent不会再被调
 *    用。这条也很好理解，就是说当一个View决定拦截一个事件后，那么系统会把同一个事件序列内的其他方法都直接交给它来处理，因此就不用再调用这个
 *    View的onInterceptTouchEvent去询问它是否要拦截了。
 *
 *    3某个View一旦开始处理事件，如果它不消耗ACTION_DOWN事件（onTouchEvent返回了false），那么同一事件序列中的其他事件都不会再交给它来
 *    处理，并且事件将重新交由它的父元素去处理，即父元素的onTouchEvent会被调用。意思就是事件一旦交给一个View处理，那么它就必须消耗掉，否则同一
 *    事件序列中剩下的事件就不再交给它来处理了，这就好比上级交给程序员一件事，如果这件事没有处理好，短期内上级就不敢再把事情交给这个程序员做
 *    了，二者是类似的道理
 *
 *    4ViewGroup默认不拦截任何事件。Android源码中ViewGroup的onInterceptTouch-Event方法默认返回false。
 *
 *    5View没有onInterceptTouchEvent方法，一旦有点击事件传递给它，那么它的onTouchEvent方法就会被调用。
 *
 *    6View的onTouchEvent默认都会消耗事件（返回true），除非它是不可点击的（clickable 和longClickable同时为false）。View的longClickable属性默认都为
 *    false，clickable属性要分情况，比如Button的clickable属性默认为true，而TextView的clickable属性默认为false。
 *
 *
 */
class MyFrameLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        when (ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                //禁止parent拦截down事件
                //但是事件依然向下分发。
                parent.requestDisallowInterceptTouchEvent(true)
            }

            MotionEvent.ACTION_MOVE -> {

            }

            MotionEvent.ACTION_UP -> {
            }
        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}