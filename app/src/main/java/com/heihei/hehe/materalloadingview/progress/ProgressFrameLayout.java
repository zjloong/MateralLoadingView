package com.heihei.hehe.materalloadingview.progress;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * 带进度条的 FrameLayout
 *
 * @author zhujinlong@ichoice.com
 * @date 2016/10/16
 * @time 11:28
 * @description Describe the place where the class needs to pay attention.
 */
public class ProgressFrameLayout extends FrameLayout {

    ProgressView mCircleView;

    private int mCircleViewIndex = -1;

    public ProgressFrameLayout(Context context) {
        this(context, null);
    }

    public ProgressFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        mCircleView = new ProgressView(context);
        FrameLayout.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        addView(mCircleView,layoutParams);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mCircleViewIndex = -1;
        // Get the index of the circleview.
        for (int index = 0; index < getChildCount(); index++) {
            if (getChildAt(index) == mCircleView) {
                mCircleViewIndex = index;
                break;
            }
        }
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        if (mCircleViewIndex < 0) {
            return i;
        } else if (i == childCount - 1) {
            // Draw the selected child last
            return mCircleViewIndex;
        } else if (i >= mCircleViewIndex) {
            // Move the children after the selected child earlier one
            return i + 1;
        } else {
            // Keep the children before the selected child the same
            return i;
        }
    }

    public void loading(boolean loading) {
        mCircleView.loading(loading);
    }
}