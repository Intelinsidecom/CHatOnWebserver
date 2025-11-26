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
import com.sec.common.C3323e;

/* loaded from: classes.dex */
public class PagerPositionStrip2 extends View implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    private ViewPager f12205a;

    /* renamed from: b */
    private PagerAdapter f12206b;

    /* renamed from: c */
    private int f12207c;

    /* renamed from: d */
    private int f12208d;

    /* renamed from: e */
    private int f12209e;

    /* renamed from: f */
    private int f12210f;

    /* renamed from: g */
    private int f12211g;

    /* renamed from: h */
    private int f12212h;

    /* renamed from: i */
    private Drawable f12213i;

    /* renamed from: j */
    private Drawable f12214j;

    /* renamed from: k */
    private Drawable f12215k;

    /* renamed from: l */
    private Drawable f12216l;

    /* renamed from: m */
    private Drawable f12217m;

    /* renamed from: n */
    private int f12218n;

    /* renamed from: o */
    private int f12219o;

    /* renamed from: p */
    private int f12220p;

    /* renamed from: q */
    private int f12221q;

    public PagerPositionStrip2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12219o = 0;
        this.f12220p = 0;
        this.f12221q = 0;
        m11933a(context, attributeSet);
    }

    public PagerPositionStrip2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12219o = 0;
        this.f12220p = 0;
        this.f12221q = 0;
        m11933a(context, attributeSet);
    }

    /* renamed from: a */
    private void m11933a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3323e.PagerPositionStrip);
        this.f12213i = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f12216l = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f12217m = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f12214j = typedArrayObtainStyledAttributes.getDrawable(3);
        this.f12215k = typedArrayObtainStyledAttributes.getDrawable(4);
        this.f12219o = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, this.f12219o);
        this.f12218n = typedArrayObtainStyledAttributes.getInt(6, 5);
        this.f12220p = this.f12213i.getIntrinsicWidth();
        this.f12221q = this.f12213i.getIntrinsicHeight();
        this.f12221q = Math.max(this.f12221q, this.f12216l.getIntrinsicHeight());
        this.f12221q = Math.max(this.f12221q, this.f12217m.getIntrinsicHeight());
        if (this.f12214j != null) {
            this.f12220p = Math.max(this.f12220p, this.f12214j.getIntrinsicWidth());
            this.f12221q = Math.max(this.f12221q, this.f12214j.getIntrinsicHeight());
        }
        if (this.f12215k != null) {
            this.f12220p = Math.max(this.f12220p, this.f12215k.getIntrinsicWidth());
            this.f12221q = Math.max(this.f12221q, this.f12215k.getIntrinsicHeight());
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
        if (this.f12211g > 0) {
            Drawable drawable2 = this.f12216l;
            int paddingLeft2 = getPaddingLeft();
            int intrinsicWidth = paddingLeft2 + drawable2.getIntrinsicWidth();
            int paddingTop = getPaddingTop();
            if (drawable2.getIntrinsicHeight() < this.f12221q) {
                paddingTop += (this.f12221q - drawable2.getIntrinsicHeight()) >> 1;
            }
            drawable2.setBounds(paddingLeft2, paddingTop, drawable2.getIntrinsicWidth() + paddingLeft2, drawable2.getIntrinsicHeight() + paddingTop);
            drawable2.draw(canvas);
            i = intrinsicWidth;
        }
        int intrinsicWidth2 = i;
        for (int i2 = this.f12209e; i2 <= this.f12210f; i2++) {
            if (i2 == 0 && this.f12214j != null) {
                drawable = this.f12214j;
            } else if (i2 == this.f12207c - 1 && this.f12215k != null) {
                drawable = this.f12215k;
            } else {
                drawable = this.f12213i;
            }
            if (i2 == 0 && this.f12211g == 0) {
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = intrinsicWidth2 + this.f12219o;
            }
            intrinsicWidth2 = drawable.getIntrinsicWidth() + paddingLeft;
            int paddingTop2 = getPaddingTop();
            if (drawable.getIntrinsicHeight() < this.f12221q) {
                paddingTop2 += (this.f12221q - drawable.getIntrinsicHeight()) >> 1;
            }
            if (this.f12208d == i2) {
                drawable.setState(SELECTED_STATE_SET);
            } else {
                drawable.setState(EMPTY_STATE_SET);
            }
            drawable.setBounds(paddingLeft, paddingTop2, drawable.getIntrinsicWidth() + paddingLeft, drawable.getIntrinsicHeight() + paddingTop2);
            drawable.draw(canvas);
        }
        if (this.f12211g != this.f12212h) {
            Drawable drawable3 = this.f12217m;
            int i3 = intrinsicWidth2 + this.f12219o;
            int intrinsicWidth3 = drawable3.getIntrinsicWidth() + i3;
            int paddingTop3 = getPaddingTop();
            if (drawable3.getIntrinsicHeight() < this.f12221q) {
                paddingTop3 += (this.f12221q - drawable3.getIntrinsicHeight()) >> 1;
            }
            drawable3.setBounds(i3, paddingTop3, drawable3.getIntrinsicWidth() + i3, drawable3.getIntrinsicHeight() + paddingTop3);
            drawable3.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iMin;
        int iMin2;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = (((this.f12220p + this.f12219o) * ((this.f12210f - this.f12209e) + 1)) - this.f12219o) + getPaddingLeft() + getPaddingRight();
        if (this.f12211g > 0) {
            paddingLeft += this.f12216l.getIntrinsicWidth() + this.f12219o;
        }
        if (this.f12211g != this.f12212h) {
            paddingLeft += this.f12217m.getIntrinsicWidth() + this.f12219o;
        }
        int paddingTop = this.f12221q + getPaddingTop() + getPaddingBottom();
        switch (mode) {
            case Integer.MIN_VALUE:
                iMin = Math.min(size, paddingLeft);
                break;
            case 0:
                iMin = paddingLeft;
                break;
            case 1073741824:
                iMin = paddingLeft;
                break;
            default:
                iMin = 0;
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                iMin2 = Math.min(size2, paddingTop);
                break;
            case 0:
                iMin2 = paddingTop;
                break;
            case 1073741824:
                iMin2 = paddingTop;
                break;
            default:
                iMin2 = 0;
                break;
        }
        setMeasuredDimension(iMin, iMin2);
    }

    public void setViewPager(ViewPager viewPager) {
        this.f12205a = viewPager;
        this.f12206b = this.f12205a.getAdapter();
        this.f12205a.setOnPageChangeListener(this);
        this.f12208d = this.f12205a.getCurrentItem();
        this.f12207c = this.f12206b.getCount();
        m11932a();
        requestLayout();
        invalidate();
    }

    public void setFirstIndicator(Drawable drawable) {
        this.f12214j = drawable;
        requestLayout();
        invalidate();
    }

    public void setIndicator(Drawable drawable) {
        this.f12213i = drawable;
        requestLayout();
        invalidate();
    }

    public void setLastIndicator(Drawable drawable) {
        this.f12215k = drawable;
        requestLayout();
        invalidate();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.f12208d = i;
        m11932a();
        requestLayout();
        invalidate();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* renamed from: a */
    private void m11932a() {
        this.f12211g = this.f12208d / this.f12218n;
        this.f12212h = (this.f12207c - 1) / this.f12218n;
        this.f12209e = this.f12211g * this.f12218n;
        this.f12210f = this.f12209e + (this.f12218n - 1);
        if (this.f12210f >= this.f12207c) {
            this.f12210f = this.f12207c - 1;
        }
    }
}
