package com.sec.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import com.sec.chaton.C0229at;

/* loaded from: classes.dex */
public class PagerPositionStrip2 extends View implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    private ViewPager f6583a;

    /* renamed from: b */
    private PagerAdapter f6584b;

    /* renamed from: c */
    private int f6585c;

    /* renamed from: d */
    private int f6586d;

    /* renamed from: e */
    private Drawable f6587e;

    /* renamed from: f */
    private Drawable f6588f;

    /* renamed from: g */
    private Drawable f6589g;

    /* renamed from: h */
    private int f6590h;

    /* renamed from: i */
    private int f6591i;

    /* renamed from: j */
    private int f6592j;

    public PagerPositionStrip2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6590h = 0;
        this.f6591i = 0;
        this.f6592j = 0;
        m6235a(context, attributeSet);
    }

    public PagerPositionStrip2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6590h = 0;
        this.f6591i = 0;
        this.f6592j = 0;
        m6235a(context, attributeSet);
    }

    /* renamed from: a */
    private void m6235a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0229at.PagerPositionStrip);
        this.f6587e = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f6588f = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f6589g = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f6590h = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, this.f6590h);
        this.f6591i = this.f6587e.getIntrinsicWidth();
        this.f6592j = this.f6587e.getIntrinsicHeight();
        if (this.f6588f != null) {
            this.f6591i = Math.max(this.f6591i, this.f6588f.getIntrinsicWidth());
            this.f6592j = Math.max(this.f6592j, this.f6588f.getIntrinsicHeight());
        }
        if (this.f6589g != null) {
            this.f6591i = Math.max(this.f6591i, this.f6589g.getIntrinsicWidth());
            this.f6592j = Math.max(this.f6592j, this.f6589g.getIntrinsicHeight());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        int paddingLeft;
        int i = 0;
        super.onDraw(canvas);
        new Paint().setAntiAlias(true);
        canvas.drawColor(0);
        int i2 = 0;
        while (i2 < this.f6585c) {
            if (i2 == 0 && this.f6588f != null) {
                drawable = this.f6588f;
            } else if (i2 == this.f6585c - 1 && this.f6589g != null) {
                drawable = this.f6589g;
            } else {
                drawable = this.f6587e;
            }
            if (i2 == 0) {
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = i + this.f6590h;
            }
            int intrinsicWidth = paddingLeft + drawable.getIntrinsicWidth();
            int paddingTop = getPaddingTop();
            if (drawable.getIntrinsicHeight() < this.f6592j) {
                paddingTop += (this.f6592j >> 1) - (drawable.getIntrinsicHeight() >> 1);
            }
            if (this.f6586d == i2) {
                drawable.setState(SELECTED_STATE_SET);
            } else {
                drawable.setState(EMPTY_STATE_SET);
            }
            drawable.setBounds(paddingLeft, paddingTop, drawable.getIntrinsicWidth() + paddingLeft, drawable.getIntrinsicHeight() + paddingTop);
            drawable.draw(canvas);
            i2++;
            i = intrinsicWidth;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingRight = getPaddingRight() + (((this.f6591i + this.f6590h) * this.f6585c) - this.f6590h) + getPaddingLeft();
        int paddingTop = this.f6592j + getPaddingTop() + getPaddingBottom();
        switch (mode) {
            case Integer.MIN_VALUE:
                paddingRight = Math.min(size, paddingRight);
                break;
            case 0:
            case 1073741824:
                break;
            default:
                paddingRight = 0;
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                paddingTop = Math.min(size2, paddingTop);
                break;
            case 0:
            case 1073741824:
                break;
            default:
                paddingTop = 0;
                break;
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    public void setViewPager(ViewPager viewPager) {
        this.f6583a = viewPager;
        this.f6584b = this.f6583a.getAdapter();
        this.f6583a.setOnPageChangeListener(this);
        this.f6586d = this.f6583a.getCurrentItem();
        this.f6585c = this.f6584b.getCount();
        invalidate();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.f6586d = i;
        invalidate();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
