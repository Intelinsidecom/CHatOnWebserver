package com.sec.common.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class HoneycombLinearLayout extends LinearLayout {

    /* renamed from: a */
    private static final int[] f18400a = {R.attr.divider, R.attr.showDividers, R.attr.dividerPadding};

    /* renamed from: b */
    private Drawable f18401b;

    /* renamed from: c */
    private int f18402c;

    /* renamed from: d */
    private int f18403d;

    /* renamed from: e */
    private int f18404e;

    /* renamed from: f */
    private int f18405f;

    /* renamed from: g */
    private boolean f18406g;

    public HoneycombLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18406g = Build.VERSION.SDK_INT < 11;
        if (this.f18406g) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f18400a);
            setDividerDrawable(typedArrayObtainStyledAttributes.getDrawable(0));
            this.f18404e = typedArrayObtainStyledAttributes.getInt(1, 0);
            this.f18405f = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.LinearLayout
    public void setShowDividers(int i) {
        if (this.f18406g) {
            if (i != this.f18404e) {
                requestLayout();
                invalidate();
            }
            this.f18404e = i;
            return;
        }
        super.setShowDividers(i);
    }

    @Override // android.widget.LinearLayout
    public int getShowDividers() {
        return this.f18406g ? this.f18404e : super.getShowDividers();
    }

    @Override // android.widget.LinearLayout
    public void setDividerDrawable(Drawable drawable) {
        if (this.f18406g) {
            if (drawable != this.f18401b) {
                if ((drawable instanceof ColorDrawable) && Build.VERSION.SDK_INT < 11) {
                    drawable = new C5064i((ColorDrawable) drawable);
                }
                this.f18401b = drawable;
                if (drawable != null) {
                    this.f18402c = drawable.getIntrinsicWidth();
                    this.f18403d = drawable.getIntrinsicHeight();
                } else {
                    this.f18402c = 0;
                    this.f18403d = 0;
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
        if (this.f18406g) {
            int iIndexOfChild = indexOfChild(view);
            int orientation = getOrientation();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            if (mo18788a(iIndexOfChild)) {
                if (orientation == 1) {
                    layoutParams.topMargin = this.f18403d;
                } else {
                    layoutParams.leftMargin = this.f18402c;
                }
            }
            int childCount = getChildCount();
            if (iIndexOfChild == childCount - 1 && mo18788a(childCount)) {
                if (orientation == 1) {
                    layoutParams.bottomMargin = this.f18403d;
                } else {
                    layoutParams.rightMargin = this.f18402c;
                }
            }
        }
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f18406g && this.f18401b != null) {
            if (getOrientation() == 1) {
                m19207a(canvas);
            } else {
                m19209b(canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* renamed from: a */
    void m19207a(Canvas canvas) {
        int bottom;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null && childAt.getVisibility() != 8 && mo18788a(i)) {
                m19208a(canvas, childAt.getTop() - ((LinearLayout.LayoutParams) childAt.getLayoutParams()).topMargin);
            }
        }
        if (mo18788a(childCount)) {
            View childAt2 = getChildAt(childCount - 1);
            if (childAt2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.f18403d;
            } else {
                bottom = childAt2.getBottom();
            }
            m19208a(canvas, bottom);
        }
    }

    /* renamed from: b */
    void m19209b(Canvas canvas) {
        int right;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null && childAt.getVisibility() != 8 && mo18788a(i)) {
                m19210b(canvas, childAt.getLeft() - ((LinearLayout.LayoutParams) childAt.getLayoutParams()).leftMargin);
            }
        }
        if (mo18788a(childCount)) {
            View childAt2 = getChildAt(childCount - 1);
            if (childAt2 == null) {
                right = (getWidth() - getPaddingRight()) - this.f18402c;
            } else {
                right = childAt2.getRight();
            }
            m19210b(canvas, right);
        }
    }

    /* renamed from: a */
    void m19208a(Canvas canvas, int i) {
        this.f18401b.setBounds(getPaddingLeft() + this.f18405f, i, (getWidth() - getPaddingRight()) - this.f18405f, this.f18403d + i);
        this.f18401b.draw(canvas);
    }

    /* renamed from: b */
    void m19210b(Canvas canvas, int i) {
        this.f18401b.setBounds(i, getPaddingTop() + this.f18405f, this.f18402c + i, (getHeight() - getPaddingBottom()) - this.f18405f);
        this.f18401b.draw(canvas);
    }

    /* renamed from: a */
    protected boolean mo18788a(int i) {
        if (i == 0) {
            return (this.f18404e & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.f18404e & 4) != 0;
        }
        if ((this.f18404e & 2) == 0) {
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
