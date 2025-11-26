package com.sec.common.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import com.sec.common.C3307b;
import com.sec.common.C3323e;

/* loaded from: classes.dex */
public class IcsSpinner extends IcsAbsSpinner implements DialogInterface.OnClickListener {

    /* renamed from: F */
    int f12199F;

    /* renamed from: G */
    private InterfaceC3391x f12200G;

    /* renamed from: H */
    private C3388u f12201H;

    /* renamed from: I */
    private int f12202I;

    /* renamed from: J */
    private boolean f12203J;

    /* renamed from: K */
    private Rect f12204K;

    public IcsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C3307b.actionDropDownStyle);
    }

    public IcsSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12204K = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3323e.SpinnerCompat, i, 0);
        C3389v c3389v = new C3389v(this, context, attributeSet, i);
        this.f12199F = typedArrayObtainStyledAttributes.getLayoutDimension(4, -2);
        c3389v.m11915a(typedArrayObtainStyledAttributes.getDrawable(2));
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0);
        if (dimensionPixelOffset != 0) {
            c3389v.m11923c(dimensionPixelOffset);
        }
        int dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 0);
        if (dimensionPixelOffset2 != 0) {
            c3389v.m11921b(dimensionPixelOffset2);
        }
        this.f12200G = c3389v;
        this.f12202I = typedArrayObtainStyledAttributes.getInt(0, 17);
        this.f12200G.mo11960a(typedArrayObtainStyledAttributes.getString(3));
        this.f12203J = true;
        typedArrayObtainStyledAttributes.recycle();
        if (this.f12201H != null) {
            this.f12200G.mo11918a(this.f12201H);
            this.f12201H = null;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f12203J) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).setEnabled(z);
            }
        }
    }

    public void setGravity(int i) {
        if (this.f12202I != i) {
            if ((i & 7) == 0) {
                i |= 3;
            }
            this.f12202I = i;
            requestLayout();
        }
    }

    @Override // com.sec.common.widget.IcsAbsSpinner, com.sec.common.widget.IcsAdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        super.setAdapter(spinnerAdapter);
        if (this.f12200G != null) {
            this.f12200G.mo11918a(new C3388u(spinnerAdapter));
        } else {
            this.f12201H = new C3388u(spinnerAdapter);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int baseline;
        View viewM11930d = null;
        if (getChildCount() > 0) {
            viewM11930d = getChildAt(0);
        } else if (this.f12139a != null && this.f12139a.getCount() > 0) {
            viewM11930d = m11930d(0);
            this.f12148j.m11956a(0, viewM11930d);
            removeAllViewsInLayout();
        }
        if (viewM11930d == null || (baseline = viewM11930d.getBaseline()) < 0) {
            return -1;
        }
        return viewM11930d.getTop() + baseline;
    }

    @Override // com.sec.common.widget.IcsAdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f12200G != null && this.f12200G.m11962d()) {
            this.f12200G.m11961b();
        }
    }

    @Override // com.sec.common.widget.IcsAdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    @Override // com.sec.common.widget.IcsAbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f12200G != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m11931a(mo11880f(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // com.sec.common.widget.IcsAdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f12166r = true;
        mo11876b(0, false);
        this.f12166r = false;
    }

    @Override // com.sec.common.widget.IcsAbsSpinner
    /* renamed from: b */
    void mo11876b(int i, boolean z) {
        int i2 = this.f12147i.left;
        int right = ((getRight() - getLeft()) - this.f12147i.left) - this.f12147i.right;
        if (this.f12170v) {
            m11898n();
        }
        if (this.f12149A == 0) {
            m11872a();
            return;
        }
        if (this.f12171w >= 0) {
            m11888b(this.f12171w);
        }
        m11875b();
        removeAllViewsInLayout();
        this.f12159k = this.f12173y;
        View viewM11930d = m11930d(this.f12173y);
        int measuredWidth = viewM11930d.getMeasuredWidth();
        switch (this.f12202I & 7) {
            case 1:
                i2 = (i2 + (right / 2)) - (measuredWidth / 2);
                break;
            case 5:
                i2 = (i2 + right) - measuredWidth;
                break;
        }
        viewM11930d.offsetLeftAndRight(i2);
        this.f12148j.m11955a();
        invalidate();
        m11899o();
        this.f12170v = false;
        this.f12164p = false;
        m11890c(this.f12173y);
    }

    /* renamed from: d */
    private View m11930d(int i) {
        View viewM11954a;
        if (!this.f12170v && (viewM11954a = this.f12148j.m11954a(i)) != null) {
            m11929c(viewM11954a);
            return viewM11954a;
        }
        View view = this.f12139a.getView(i, null, this);
        m11929c(view);
        return view;
    }

    /* renamed from: c */
    private void m11929c(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addViewInLayout(view, 0, layoutParams);
        view.setSelected(hasFocus());
        if (this.f12203J) {
            view.setEnabled(isEnabled());
        }
        view.measure(ViewGroup.getChildMeasureSpec(this.f12141c, this.f12147i.left + this.f12147i.right, layoutParams.width), ViewGroup.getChildMeasureSpec(this.f12140b, this.f12147i.top + this.f12147i.bottom, layoutParams.height));
        int measuredHeight = this.f12147i.top + ((((getMeasuredHeight() - this.f12147i.bottom) - this.f12147i.top) - view.getMeasuredHeight()) / 2);
        view.layout(0, measuredHeight, view.getMeasuredWidth() + 0, view.getMeasuredHeight() + measuredHeight);
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (!zPerformClick) {
            zPerformClick = true;
            if (!this.f12200G.m11962d()) {
                this.f12200G.mo11913a();
            }
        }
        return zPerformClick;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        setSelection(i);
        dialogInterface.dismiss();
    }

    public void setPrompt(CharSequence charSequence) {
        this.f12200G.mo11960a(charSequence);
    }

    public void setPromptId(int i) {
        setPrompt(getContext().getText(i));
    }

    /* renamed from: a */
    int m11931a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        View view;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMax = Math.max(0, m11891g());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        int iMax2 = Math.max(0, iMax - (15 - (iMin - iMax)));
        View view2 = null;
        int iMax3 = 0;
        int i = 0;
        while (iMax2 < iMin) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax2);
            if (itemViewType != i) {
                view = null;
            } else {
                itemViewType = i;
                view = view2;
            }
            view2 = spinnerAdapter.getView(iMax2, view, this);
            if (view2.getLayoutParams() == null) {
                view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax3 = Math.max(iMax3, view2.getMeasuredWidth());
            iMax2++;
            i = itemViewType;
        }
        if (drawable == null) {
            return iMax3;
        }
        drawable.getPadding(this.f12204K);
        return this.f12204K.left + this.f12204K.right + iMax3;
    }
}
