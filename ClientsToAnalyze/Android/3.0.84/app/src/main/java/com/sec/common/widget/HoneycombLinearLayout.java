package com.sec.common.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class HoneycombLinearLayout extends LinearLayout {

    /* renamed from: a */
    private static final int[] f12130a = {R.attr.divider, R.attr.showDividers, R.attr.dividerPadding};

    /* renamed from: b */
    private Drawable f12131b;

    /* renamed from: c */
    private int f12132c;

    /* renamed from: d */
    private int f12133d;

    /* renamed from: e */
    private int f12134e;

    /* renamed from: f */
    private int f12135f;

    /* renamed from: g */
    private boolean f12136g;

    public HoneycombLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12136g = Build.VERSION.SDK_INT < 11;
        if (this.f12136g) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f12130a);
            setDividerDrawable(typedArrayObtainStyledAttributes.getDrawable(0));
            this.f12134e = typedArrayObtainStyledAttributes.getInt(1, 0);
            this.f12135f = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.LinearLayout
    public void setShowDividers(int i) {
        if (this.f12136g) {
            if (i != this.f12134e) {
                requestLayout();
                invalidate();
            }
            this.f12134e = i;
            return;
        }
        super.setShowDividers(i);
    }

    @Override // android.widget.LinearLayout
    public int getShowDividers() {
        return this.f12136g ? this.f12134e : super.getShowDividers();
    }

    @Override // android.widget.LinearLayout
    public void setDividerDrawable(Drawable drawable) {
        if (this.f12136g) {
            if (drawable != this.f12131b) {
                if ((drawable instanceof ColorDrawable) && Build.VERSION.SDK_INT < 11) {
                    drawable = new C3380m((ColorDrawable) drawable);
                }
                this.f12131b = drawable;
                if (drawable != null) {
                    this.f12132c = drawable.getIntrinsicWidth();
                    this.f12133d = drawable.getIntrinsicHeight();
                } else {
                    this.f12132c = 0;
                    this.f12133d = 0;
                }
                setWillNotDraw(drawable == null);
                requestLayout();
                return;
            }
            return;
        }
        super.setDividerDrawable(drawable);
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        if (this.f12136g) {
            int iIndexOfChild = indexOfChild(view);
            int orientation = getOrientation();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            if (mo11547a(iIndexOfChild)) {
                if (orientation == 1) {
                    layoutParams.topMargin = this.f12133d;
                } else {
                    layoutParams.leftMargin = this.f12132c;
                }
            }
            int childCount = getChildCount();
            if (iIndexOfChild == childCount - 1 && mo11547a(childCount)) {
                if (orientation == 1) {
                    layoutParams.bottomMargin = this.f12133d;
                } else {
                    layoutParams.rightMargin = this.f12132c;
                }
            }
        }
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f12136g && this.f12131b != null) {
            if (getOrientation() == 1) {
                m11865a(canvas);
            } else {
                m11867b(canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* renamed from: a */
    void m11865a(Canvas canvas) {
        int bottom;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null && childAt.getVisibility() != 8 && mo11547a(i)) {
                m11866a(canvas, childAt.getTop() - ((LinearLayout.LayoutParams) childAt.getLayoutParams()).topMargin);
            }
        }
        if (mo11547a(childCount)) {
            View childAt2 = getChildAt(childCount - 1);
            if (childAt2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.f12133d;
            } else {
                bottom = childAt2.getBottom();
            }
            m11866a(canvas, bottom);
        }
    }

    /* renamed from: b */
    void m11867b(Canvas canvas) {
        int right;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null && childAt.getVisibility() != 8 && mo11547a(i)) {
                m11868b(canvas, childAt.getLeft() - ((LinearLayout.LayoutParams) childAt.getLayoutParams()).leftMargin);
            }
        }
        if (mo11547a(childCount)) {
            View childAt2 = getChildAt(childCount - 1);
            if (childAt2 == null) {
                right = (getWidth() - getPaddingRight()) - this.f12132c;
            } else {
                right = childAt2.getRight();
            }
            m11868b(canvas, right);
        }
    }

    /* renamed from: a */
    void m11866a(Canvas canvas, int i) {
        this.f12131b.setBounds(getPaddingLeft() + this.f12135f, i, (getWidth() - getPaddingRight()) - this.f12135f, this.f12133d + i);
        this.f12131b.draw(canvas);
    }

    /* renamed from: b */
    void m11868b(Canvas canvas, int i) {
        this.f12131b.setBounds(i, getPaddingTop() + this.f12135f, this.f12132c + i, (getHeight() - getPaddingBottom()) - this.f12135f);
        this.f12131b.draw(canvas);
    }

    /* renamed from: a */
    protected boolean mo11547a(int i) {
        if (i == 0) {
            return (this.f12134e & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.f12134e & 4) != 0;
        }
        if ((this.f12134e & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }
}
