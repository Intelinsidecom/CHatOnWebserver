package com.sec.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public abstract class IcsAbsSpinner extends IcsAdapterView<SpinnerAdapter> {

    /* renamed from: F */
    private static final boolean f18407F;

    /* renamed from: G */
    private DataSetObserver f18408G;

    /* renamed from: a */
    SpinnerAdapter f18409a;

    /* renamed from: b */
    int f18410b;

    /* renamed from: c */
    int f18411c;

    /* renamed from: d */
    boolean f18412d;

    /* renamed from: e */
    int f18413e;

    /* renamed from: f */
    int f18414f;

    /* renamed from: g */
    int f18415g;

    /* renamed from: h */
    int f18416h;

    /* renamed from: i */
    final Rect f18417i;

    /* renamed from: j */
    final C5057b f18418j;

    /* renamed from: b */
    abstract void mo19218b(int i, boolean z);

    static {
        f18407F = Build.VERSION.SDK_INT >= 11;
    }

    public IcsAbsSpinner(Context context) {
        super(context);
        this.f18413e = 0;
        this.f18414f = 0;
        this.f18415g = 0;
        this.f18416h = 0;
        this.f18417i = new Rect();
        this.f18418j = new C5057b(this);
        m19212r();
    }

    public IcsAbsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IcsAbsSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18413e = 0;
        this.f18414f = 0;
        this.f18415g = 0;
        this.f18416h = 0;
        this.f18417i = new Rect();
        this.f18418j = new C5057b(this);
        m19212r();
    }

    /* renamed from: r */
    private void m19212r() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    @Override // com.sec.common.widget.IcsAdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f18409a != null) {
            this.f18409a.unregisterDataSetObserver(this.f18408G);
            m19214a();
        }
        this.f18409a = spinnerAdapter;
        this.f18421C = -1;
        this.f18422D = Long.MIN_VALUE;
        if (this.f18409a != null) {
            this.f18420B = this.f18419A;
            this.f18419A = this.f18409a.getCount();
            m19238l();
            this.f18408G = new C5060e(this);
            this.f18409a.registerDataSetObserver(this.f18408G);
            int i = this.f18419A > 0 ? 0 : -1;
            m19230b(i);
            m19232c(i);
            if (this.f18419A == 0) {
                m19241o();
            }
        } else {
            m19238l();
            m19214a();
            m19241o();
        }
        requestLayout();
    }

    /* renamed from: a */
    void m19214a() {
        this.f18440v = false;
        this.f18434p = false;
        removeAllViewsInLayout();
        this.f18421C = -1;
        this.f18422D = Long.MIN_VALUE;
        m19230b(-1);
        m19232c(-1);
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ee  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r10, int r11) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.common.widget.IcsAbsSpinner.onMeasure(int, int):void");
    }

    /* renamed from: a */
    int m19213a(View view) {
        return view.getMeasuredHeight();
    }

    /* renamed from: b */
    int m19216b(View view) {
        return view.getMeasuredWidth();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    /* renamed from: b */
    void m19217b() {
        int childCount = getChildCount();
        C5057b c5057b = this.f18418j;
        int i = this.f18429k;
        for (int i2 = 0; i2 < childCount; i2++) {
            c5057b.m19278a(i + i2, getChildAt(i2));
        }
    }

    public void setSelection(int i, boolean z) {
        m19215a(i, z && this.f18429k <= i && i <= (this.f18429k + getChildCount()) + (-1));
    }

    @Override // com.sec.common.widget.IcsAdapterView
    public void setSelection(int i) {
        m19232c(i);
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    void m19215a(int i, boolean z) {
        if (i != this.f18421C) {
            this.f18412d = true;
            int i2 = i - this.f18443y;
            m19232c(i);
            mo19218b(i2, z);
            this.f18412d = false;
        }
    }

    @Override // com.sec.common.widget.IcsAdapterView
    /* renamed from: c */
    public View mo19219c() {
        if (this.f18419A <= 0 || this.f18443y < 0) {
            return null;
        }
        return getChildAt(this.f18443y - this.f18429k);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f18412d) {
            super.requestLayout();
        }
    }

    @Override // com.sec.common.widget.IcsAdapterView
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public SpinnerAdapter mo19222f() {
        return this.f18409a;
    }

    @Override // com.sec.common.widget.IcsAdapterView
    /* renamed from: e */
    public int mo19221e() {
        return this.f18419A;
    }

    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C5058c();
        int position;
        long selectedId;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.selectedId = parcel.readLong();
            this.position = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.selectedId);
            parcel.writeInt(this.position);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.selectedId = m19234h();
        if (savedState.selectedId >= 0) {
            savedState.position = m19233g();
        } else {
            savedState.position = -1;
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.selectedId >= 0) {
            this.f18440v = true;
            this.f18434p = true;
            this.f18432n = savedState.selectedId;
            this.f18431m = savedState.position;
            this.f18435q = 0;
            requestLayout();
        }
    }
}
