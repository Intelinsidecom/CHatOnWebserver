package com.sec.chaton.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.p076m.C2575g;

/* loaded from: classes.dex */
public class WeightHorizontalLayout extends ViewGroup {

    /* renamed from: a */
    private int f17933a;

    /* renamed from: b */
    private int f17934b;

    /* renamed from: c */
    private int f17935c;

    /* renamed from: d */
    private int f17936d;

    /* renamed from: e */
    private int f17937e;

    /* renamed from: f */
    private int f17938f;

    /* renamed from: g */
    private int f17939g;

    /* renamed from: h */
    private int f17940h;

    /* renamed from: i */
    private View f17941i;

    /* renamed from: j */
    private View f17942j;

    /* renamed from: k */
    private LayoutParams f17943k;

    /* renamed from: l */
    private LayoutParams f17944l;

    /* renamed from: m */
    private int f17945m;

    /* renamed from: n */
    private int f17946n;

    /* renamed from: o */
    private int f17947o;

    /* renamed from: p */
    private int f17948p;

    /* renamed from: q */
    private int f17949q;

    /* renamed from: r */
    private int f17950r;

    public WeightHorizontalLayout(Context context) {
        super(context);
    }

    public WeightHorizontalLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WeightHorizontalLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.f17933a = View.MeasureSpec.getMode(i);
        this.f17934b = View.MeasureSpec.getMode(i2);
        this.f17935c = View.MeasureSpec.getSize(i);
        this.f17936d = View.MeasureSpec.getSize(i2);
        this.f17937e = 0;
        this.f17938f = 0;
        this.f17939g = 0;
        this.f17940h = getChildCount();
        if (this.f17940h >= 2) {
            this.f17941i = getChildAt(0);
            this.f17942j = getChildAt(1);
            this.f17943k = (LayoutParams) this.f17941i.getLayoutParams();
            this.f17944l = (LayoutParams) this.f17942j.getLayoutParams();
            this.f17945m = 0;
            this.f17946n = 0;
            if (this.f17941i.getVisibility() != 8) {
                measureChildWithMargins(this.f17941i, View.MeasureSpec.makeMeasureSpec(this.f17935c, 0), 0, i2, 0);
                this.f17945m = this.f17941i.getMeasuredWidth() + this.f17943k.leftMargin + this.f17943k.rightMargin;
            } else {
                this.f17945m = 0;
            }
            if (this.f17942j.getVisibility() != 8) {
                measureChildWithMargins(this.f17942j, View.MeasureSpec.makeMeasureSpec(this.f17935c, 0), 0, i2, 0);
                this.f17946n = this.f17942j.getMeasuredWidth() + this.f17944l.leftMargin + this.f17944l.rightMargin;
            } else {
                this.f17946n = 0;
            }
            this.f17939g = this.f17945m + this.f17946n;
            this.f17938f = Math.max(this.f17941i.getMeasuredHeight(), this.f17942j.getMeasuredHeight());
            switch (this.f17933a) {
                case Integer.MIN_VALUE:
                    this.f17937e = Math.min(this.f17937e, this.f17935c);
                    break;
                case 1073741824:
                    this.f17937e = this.f17935c;
                    break;
            }
            switch (this.f17934b) {
                case Integer.MIN_VALUE:
                    this.f17938f = Math.min(this.f17938f, this.f17936d);
                    break;
                case 1073741824:
                    this.f17938f = this.f17936d;
                    break;
            }
            this.f17937e = Math.max(this.f17937e, getSuggestedMinimumWidth());
            this.f17938f = Math.max(this.f17938f, getSuggestedMinimumHeight());
            setMeasuredDimension(this.f17937e, this.f17938f);
            if (this.f17939g <= this.f17935c) {
                this.f17947o = View.MeasureSpec.makeMeasureSpec(this.f17935c, 0);
                this.f17949q = View.MeasureSpec.makeMeasureSpec(this.f17935c - this.f17945m, 1073741824);
            } else {
                this.f17947o = View.MeasureSpec.makeMeasureSpec(this.f17935c - this.f17946n, 1073741824);
                this.f17949q = View.MeasureSpec.makeMeasureSpec(this.f17935c, 0);
            }
            if (this.f17943k.height == -1) {
                this.f17948p = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            } else {
                this.f17948p = i2;
            }
            if (this.f17944l.height == -1) {
                this.f17950r = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            } else {
                this.f17950r = i2;
            }
            if (this.f17941i.getVisibility() != 8) {
                measureChildWithMargins(this.f17941i, this.f17947o, 0, this.f17948p, 0);
            }
            if (this.f17942j.getVisibility() != 8) {
                measureChildWithMargins(this.f17942j, this.f17949q, 0, this.f17950r, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int childCount = getChildCount();
        if (childCount >= 2) {
            int i6 = 0;
            int i7 = 0;
            while (i6 < childCount) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int i8 = i7 + layoutParams.leftMargin;
                    int measuredWidth = i8 + childAt.getMeasuredWidth();
                    int measuredHeight = layoutParams.topMargin;
                    switch (layoutParams.f17951a & 112) {
                        case 16:
                            measuredHeight = (((i4 - i2) - childAt.getMeasuredHeight()) / 2) + layoutParams.topMargin;
                            break;
                        case 80:
                            measuredHeight = ((i4 - i2) - childAt.getMeasuredHeight()) + layoutParams.topMargin;
                            break;
                    }
                    childAt.layout(i8, measuredHeight, measuredWidth, childAt.getMeasuredHeight() + measuredHeight);
                    i5 = layoutParams.rightMargin + measuredWidth + i7;
                } else {
                    i5 = i7;
                }
                i6++;
                i7 = i5;
            }
        }
    }

    public class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f17951a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f17951a = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2575g.WeightHorizontalLayout_Layout);
            this.f17951a = typedArrayObtainStyledAttributes.getInt(0, -1);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
