package com.sec.common.widget;

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

/* loaded from: classes.dex */
public abstract class IcsAbsSpinner extends IcsAdapterView<SpinnerAdapter> {

    /* renamed from: F */
    private static final boolean f12137F;

    /* renamed from: G */
    private DataSetObserver f12138G;

    /* renamed from: a */
    SpinnerAdapter f12139a;

    /* renamed from: b */
    int f12140b;

    /* renamed from: c */
    int f12141c;

    /* renamed from: d */
    boolean f12142d;

    /* renamed from: e */
    int f12143e;

    /* renamed from: f */
    int f12144f;

    /* renamed from: g */
    int f12145g;

    /* renamed from: h */
    int f12146h;

    /* renamed from: i */
    final Rect f12147i;

    /* renamed from: j */
    final C3373f f12148j;

    /* renamed from: b */
    abstract void mo11876b(int i, boolean z);

    static {
        f12137F = Build.VERSION.SDK_INT >= 11;
    }

    public IcsAbsSpinner(Context context) {
        super(context);
        this.f12143e = 0;
        this.f12144f = 0;
        this.f12145g = 0;
        this.f12146h = 0;
        this.f12147i = new Rect();
        this.f12148j = new C3373f(this);
        m11870r();
    }

    public IcsAbsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IcsAbsSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12143e = 0;
        this.f12144f = 0;
        this.f12145g = 0;
        this.f12146h = 0;
        this.f12147i = new Rect();
        this.f12148j = new C3373f(this);
        m11870r();
    }

    /* renamed from: r */
    private void m11870r() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    @Override // com.sec.common.widget.IcsAdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f12139a != null) {
            this.f12139a.unregisterDataSetObserver(this.f12138G);
            m11872a();
        }
        this.f12139a = spinnerAdapter;
        this.f12151C = -1;
        this.f12152D = Long.MIN_VALUE;
        if (this.f12139a != null) {
            this.f12150B = this.f12149A;
            this.f12149A = this.f12139a.getCount();
            m11896l();
            this.f12138G = new C3376i(this);
            this.f12139a.registerDataSetObserver(this.f12138G);
            int i = this.f12149A > 0 ? 0 : -1;
            m11888b(i);
            m11890c(i);
            if (this.f12149A == 0) {
                m11899o();
            }
        } else {
            m11896l();
            m11872a();
            m11899o();
        }
        requestLayout();
    }

    /* renamed from: a */
    void m11872a() {
        this.f12170v = false;
        this.f12164p = false;
        removeAllViewsInLayout();
        this.f12151C = -1;
        this.f12152D = Long.MIN_VALUE;
        m11888b(-1);
        m11890c(-1);
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
    int m11871a(View view) {
        return view.getMeasuredHeight();
    }

    /* renamed from: b */
    int m11874b(View view) {
        return view.getMeasuredWidth();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    /* renamed from: b */
    void m11875b() {
        int childCount = getChildCount();
        C3373f c3373f = this.f12148j;
        int i = this.f12159k;
        for (int i2 = 0; i2 < childCount; i2++) {
            c3373f.m11956a(i + i2, getChildAt(i2));
        }
    }

    public void setSelection(int i, boolean z) {
        m11873a(i, z && this.f12159k <= i && i <= (this.f12159k + getChildCount()) + (-1));
    }

    @Override // com.sec.common.widget.IcsAdapterView
    public void setSelection(int i) {
        m11890c(i);
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    void m11873a(int i, boolean z) {
        if (i != this.f12151C) {
            this.f12142d = true;
            int i2 = i - this.f12173y;
            m11890c(i);
            mo11876b(i2, z);
            this.f12142d = false;
        }
    }

    @Override // com.sec.common.widget.IcsAdapterView
    /* renamed from: c */
    public View mo11877c() {
        if (this.f12149A <= 0 || this.f12173y < 0) {
            return null;
        }
        return getChildAt(this.f12173y - this.f12159k);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f12142d) {
            super.requestLayout();
        }
    }

    @Override // com.sec.common.widget.IcsAdapterView
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public SpinnerAdapter mo11880f() {
        return this.f12139a;
    }

    @Override // com.sec.common.widget.IcsAdapterView
    /* renamed from: e */
    public int mo11879e() {
        return this.f12149A;
    }

    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C3374g();
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
        savedState.selectedId = m11892h();
        if (savedState.selectedId >= 0) {
            savedState.position = m11891g();
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
            this.f12170v = true;
            this.f12164p = true;
            this.f12162n = savedState.selectedId;
            this.f12161m = savedState.position;
            this.f12165q = 0;
            requestLayout();
        }
    }
}
