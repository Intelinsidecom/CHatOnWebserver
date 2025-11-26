package com.sec.chaton.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class WeightedLinearLayout extends LinearLayout {

    /* renamed from: a */
    private float f17952a;

    /* renamed from: b */
    private float f17953b;

    public WeightedLinearLayout(Context context) {
        super(context);
    }

    public WeightedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17952a = 0.65f;
        this.f17953b = 0.9f;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        boolean z = false;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        boolean z2 = i3 < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i);
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        float f = z2 ? this.f17953b : this.f17952a;
        if (mode != Integer.MIN_VALUE || f <= 0.0f || measuredWidth >= i3 * f) {
            iMakeMeasureSpec = iMakeMeasureSpec2;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (f * i3), 1073741824);
            z = true;
        }
        if (z) {
            super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec3);
        }
    }
}
