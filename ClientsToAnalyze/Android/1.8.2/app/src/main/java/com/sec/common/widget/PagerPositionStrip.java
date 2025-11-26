package com.sec.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class PagerPositionStrip extends View implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    private ViewPager f6576a;

    /* renamed from: b */
    private PagerAdapter f6577b;

    /* renamed from: c */
    private int f6578c;

    /* renamed from: d */
    private int f6579d;

    /* renamed from: e */
    private int f6580e;

    /* renamed from: f */
    private int f6581f;

    /* renamed from: g */
    private int f6582g;

    public PagerPositionStrip(Context context) {
        super(context);
        this.f6580e = 10;
        this.f6581f = 5;
        this.f6582g = this.f6581f + this.f6581f;
    }

    public PagerPositionStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6580e = 10;
        this.f6581f = 5;
        this.f6582g = this.f6581f + this.f6581f;
    }

    public PagerPositionStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6580e = 10;
        this.f6581f = 5;
        this.f6582g = this.f6581f + this.f6581f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int paddingLeft;
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawColor(0);
        for (int i = 0; i < this.f6578c; i++) {
            int i2 = (this.f6582g * i) + this.f6581f;
            if (i == 0) {
                paddingLeft = i2 + getPaddingLeft();
            } else {
                paddingLeft = i2 + (this.f6580e * i);
            }
            int paddingTop = this.f6581f + getPaddingTop();
            if (i == this.f6579d) {
                paint.setColor(-16776961);
            } else {
                paint.setColor(-1);
            }
            canvas.drawCircle(paddingLeft, paddingTop, this.f6581f, paint);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingRight = getPaddingRight() + (((this.f6582g + this.f6580e) * this.f6578c) - this.f6580e) + getPaddingLeft();
        int paddingTop = this.f6582g + getPaddingTop() + getPaddingBottom();
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
        this.f6576a = viewPager;
        this.f6577b = this.f6576a.getAdapter();
        this.f6576a.setOnPageChangeListener(this);
        this.f6579d = this.f6576a.getCurrentItem();
        this.f6578c = this.f6577b.getCount();
        invalidate();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.f6579d = i;
        invalidate();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
