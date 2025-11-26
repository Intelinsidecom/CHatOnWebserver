package com.sec.common.tooltip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ToolTipLayout extends FrameLayout {
    public ToolTipLayout(Context context) {
        super(context);
    }

    public ToolTipLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ToolTipLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < getChildCount()) {
                try {
                    ToolTipView toolTipView = (ToolTipView) getChildAt(i6);
                    if (toolTipView != null) {
                        toolTipView.m19037a();
                    }
                } catch (ClassCastException e) {
                }
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < getChildCount()) {
                try {
                    ToolTipView toolTipView = (ToolTipView) getChildAt(i4);
                    if (toolTipView != null) {
                        toolTipView.m19037a();
                    }
                } catch (ClassCastException e) {
                }
                i3 = i4 + 1;
            } else {
                super.onMeasure(i, i2);
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= getChildCount()) {
                    break;
                }
                try {
                    C5011a c5011a = (C5011a) ((ToolTipView) getChildAt(i2)).getTag();
                    if (c5011a != null) {
                        c5011a.m19041a();
                    }
                } catch (ClassCastException e) {
                }
                i = i2 + 1;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
