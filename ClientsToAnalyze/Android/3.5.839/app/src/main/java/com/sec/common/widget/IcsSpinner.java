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
import com.sec.common.C4969b;
import com.sec.common.C4991e;

/* loaded from: classes.dex */
public class IcsSpinner extends IcsAbsSpinner implements DialogInterface.OnClickListener {

    /* renamed from: F */
    int f18469F;

    /* renamed from: G */
    private InterfaceC5076u f18470G;

    /* renamed from: H */
    private C5073r f18471H;

    /* renamed from: I */
    private int f18472I;

    /* renamed from: J */
    private boolean f18473J;

    /* renamed from: K */
    private Rect f18474K;

    public IcsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C4969b.actionDropDownStyle);
    }

    public IcsSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18474K = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4991e.SpinnerCompat, i, 0);
        C5074s c5074s = new C5074s(this, context, attributeSet, i);
        this.f18469F = typedArrayObtainStyledAttributes.getLayoutDimension(4, -2);
        c5074s.m19257a(typedArrayObtainStyledAttributes.getDrawable(2));
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0);
        if (dimensionPixelOffset != 0) {
            c5074s.m19265c(dimensionPixelOffset);
        }
        int dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 0);
        if (dimensionPixelOffset2 != 0) {
            c5074s.m19263b(dimensionPixelOffset2);
        }
        this.f18470G = c5074s;
        this.f18472I = typedArrayObtainStyledAttributes.getInt(0, 17);
        this.f18470G.mo19282a(typedArrayObtainStyledAttributes.getString(3));
        this.f18473J = true;
        typedArrayObtainStyledAttributes.recycle();
        if (this.f18471H != null) {
            this.f18470G.mo19260a(this.f18471H);
            this.f18471H = null;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f18473J) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).setEnabled(z);
            }
        }
    }

    public void setGravity(int i) {
        if (this.f18472I != i) {
            if ((i & 7) == 0) {
                i |= 3;
            }
            this.f18472I = i;
            requestLayout();
        }
    }

    @Override // com.sec.common.widget.IcsAbsSpinner, com.sec.common.widget.IcsAdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        super.setAdapter(spinnerAdapter);
        if (this.f18470G != null) {
            this.f18470G.mo19260a(new C5073r(spinnerAdapter));
        } else {
            this.f18471H = new C5073r(spinnerAdapter);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int baseline;
        View viewM19272d = null;
        if (getChildCount() > 0) {
            viewM19272d = getChildAt(0);
        } else if (this.f18409a != null && this.f18409a.getCount() > 0) {
            viewM19272d = m19272d(0);
            this.f18418j.m19278a(0, viewM19272d);
            removeAllViewsInLayout();
        }
        if (viewM19272d == null || (baseline = viewM19272d.getBaseline()) < 0) {
            return -1;
        }
        return viewM19272d.getTop() + baseline;
    }

    @Override // com.sec.common.widget.IcsAdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f18470G != null && this.f18470G.m19284d()) {
            this.f18470G.m19283b();
        }
    }

    @Override // com.sec.common.widget.IcsAdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    @Override // com.sec.common.widget.IcsAbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f18470G != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m19273a(mo19222f(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // com.sec.common.widget.IcsAdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f18436r = true;
        mo19218b(0, false);
        this.f18436r = false;
    }

    @Override // com.sec.common.widget.IcsAbsSpinner
    /* renamed from: b */
    void mo19218b(int i, boolean z) {
        int i2 = this.f18417i.left;
        int right = ((getRight() - getLeft()) - this.f18417i.left) - this.f18417i.right;
        if (this.f18440v) {
            m19240n();
        }
        if (this.f18419A == 0) {
            m19214a();
            return;
        }
        if (this.f18441w >= 0) {
            m19230b(this.f18441w);
        }
        m19217b();
        removeAllViewsInLayout();
        this.f18429k = this.f18443y;
        View viewM19272d = m19272d(this.f18443y);
        int measuredWidth = viewM19272d.getMeasuredWidth();
        switch (this.f18472I & 7) {
            case 1:
                i2 = (i2 + (right / 2)) - (measuredWidth / 2);
                break;
            case 5:
                i2 = (i2 + right) - measuredWidth;
                break;
        }
        viewM19272d.offsetLeftAndRight(i2);
        this.f18418j.m19277a();
        invalidate();
        m19241o();
        this.f18440v = false;
        this.f18434p = false;
        m19232c(this.f18443y);
    }

    /* renamed from: d */
    private View m19272d(int i) {
        View viewM19276a;
        if (!this.f18440v && (viewM19276a = this.f18418j.m19276a(i)) != null) {
            m19271c(viewM19276a);
            return viewM19276a;
        }
        View view = this.f18409a.getView(i, null, this);
        m19271c(view);
        return view;
    }

    /* renamed from: c */
    private void m19271c(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addViewInLayout(view, 0, layoutParams);
        view.setSelected(hasFocus());
        if (this.f18473J) {
            view.setEnabled(isEnabled());
        }
        view.measure(ViewGroup.getChildMeasureSpec(this.f18411c, this.f18417i.left + this.f18417i.right, layoutParams.width), ViewGroup.getChildMeasureSpec(this.f18410b, this.f18417i.top + this.f18417i.bottom, layoutParams.height));
        int measuredHeight = this.f18417i.top + ((((getMeasuredHeight() - this.f18417i.bottom) - this.f18417i.top) - view.getMeasuredHeight()) / 2);
        view.layout(0, measuredHeight, view.getMeasuredWidth() + 0, view.getMeasuredHeight() + measuredHeight);
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (!zPerformClick) {
            zPerformClick = true;
            if (!this.f18470G.m19284d()) {
                this.f18470G.mo19255a();
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
        this.f18470G.mo19282a(charSequence);
    }

    public void setPromptId(int i) {
        setPrompt(getContext().getText(i));
    }

    /* renamed from: a */
    int m19273a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        View view;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMax = Math.max(0, m19233g());
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
        drawable.getPadding(this.f18474K);
        return this.f18474K.left + this.f18474K.right + iMax3;
    }
}
