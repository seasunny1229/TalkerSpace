package com.seasunny.framework.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.seasunny.framework.util.LogUtil;

/*
*
* https://blog.csdn.net/u013353866/article/details/48597251?locationNum=9&fps=1
*
*/

public class BaseView extends View {

    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // region creation
    //onFinishInflate() 当View中所有的子控件均被映射成xml后触发
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LogUtil.lifecycle(getClass(), "onFinishInflate");
    }
    // endregion

    // region layout
    //onMeasure(int, int) 确定所有子元素的大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        LogUtil.lifecycle(getClass(), "onMeasure: " + "widthMeasureSpec: " + widthMeasureSpec + " " + "heightMeasureSpec: " + heightMeasureSpec);
    }

    //onLayout(boolean, int, int, int, int) 当View分配所有的子元素的大小和位置时触发
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        LogUtil.lifecycle(getClass(), "onLayout: " + "changed: " + changed + " left: " + left + " top: " + top + " right: " + right + " bottom: " + bottom);
    }

    //onSizeChanged(int, int, int, int) 当view的大小发生变化时触发
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        LogUtil.lifecycle(getClass(), "onSizeChanged");
        super.onSizeChanged(w, h, oldw, oldh);
    }
    // endregion

    // region draw
    //onDraw(Canvas) view渲染内容的细节
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LogUtil.lifecycle(getClass(), "onDraw");
    }
    // endregion

    // region event processing

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        LogUtil.lifecycle(getClass(), "onKeyDown");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        LogUtil.lifecycle(getClass(), "onKeyUp");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        LogUtil.lifecycle(getClass(), "onTrackballEvent");
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.lifecycle(getClass(), "onTouchEvent");
        return super.onTouchEvent(event);
    }

    // endregion

    // region focus
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        LogUtil.lifecycle(getClass(), "onFocusChanged");
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        LogUtil.lifecycle(getClass(), "onWindowFocusChanged");
    }

    // endregion

    // region attaching

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtil.lifecycle(getClass(), "onAttachedToWindow");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtil.lifecycle(getClass(), "onDetachedFromWindow");
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        LogUtil.lifecycle(getClass(), "onWindowVisibilityChanged");
    }

    // endregion

}
