package com.sec.chaton.settings.theme;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;

/* loaded from: classes.dex */
public abstract class CarouselSpinner extends CarouselAdapter {

    /* renamed from: A */
    int f3258A;

    /* renamed from: B */
    int f3259B;

    /* renamed from: C */
    int f3260C;

    /* renamed from: D */
    final Rect f3261D;

    /* renamed from: E */
    final C0516g f3262E;

    /* renamed from: F */
    private DataSetObserver f3263F;

    /* renamed from: v */
    SpinnerAdapter f3264v;

    /* renamed from: w */
    int f3265w;

    /* renamed from: x */
    int f3266x;

    /* renamed from: y */
    boolean f3267y;

    /* renamed from: z */
    int f3268z;

    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new C0517h();
        int position;
        long selectedId;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.selectedId = parcel.readLong();
            this.position = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.selectedId);
            parcel.writeInt(this.position);
        }
    }

    public CarouselSpinner(Context context) {
        super(context);
        this.f3268z = 0;
        this.f3258A = 0;
        this.f3259B = 0;
        this.f3260C = 0;
        this.f3261D = new Rect();
        this.f3262E = new C0516g(this);
        m3267p();
    }

    public CarouselSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarouselSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3268z = 0;
        this.f3258A = 0;
        this.f3259B = 0;
        this.f3260C = 0;
        this.f3261D = new Rect();
        this.f3262E = new C0516g(this);
        m3267p();
    }

    /* renamed from: p */
    private void m3267p() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    /* renamed from: a */
    abstract void mo3238a(int i, boolean z);

    /* renamed from: b */
    int m3268b(View view) {
        return view.getMeasuredHeight();
    }

    /* renamed from: c */
    int m3269c(View view) {
        return view.getMeasuredWidth();
    }

    /* renamed from: c */
    void m3270c(int i, boolean z) {
        if (i != this.f3241s) {
            this.f3267y = true;
            int i2 = i - this.f3237o;
            m3250c(i);
            mo3238a(i2, z);
            this.f3267y = false;
        }
    }

    @Override // com.sec.chaton.settings.theme.CarouselAdapter
    /* renamed from: e */
    public View mo3252e() {
        if (this.f3239q <= 0 || this.f3237o < 0) {
            return null;
        }
        return getChildAt(this.f3237o - this.f3223a);
    }

    @Override // com.sec.chaton.settings.theme.CarouselAdapter
    /* renamed from: f */
    public int mo3253f() {
        return this.f3239q;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    @Override // com.sec.chaton.settings.theme.CarouselAdapter
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public SpinnerAdapter mo3248b() {
        return this.f3264v;
    }

    /* renamed from: n */
    void m3272n() {
        this.f3234l = false;
        this.f3228f = false;
        removeAllViewsInLayout();
        this.f3241s = -1;
        this.f3242t = Long.MIN_VALUE;
        mo3237a(-1);
        m3250c(-1);
        invalidate();
    }

    /* renamed from: o */
    void m3273o() {
        int childCount = getChildCount();
        C0516g c0516g = this.f3262E;
        int i = this.f3223a;
        for (int i2 = 0; i2 < childCount; i2++) {
            c0516g.m3287a(i + i2, getChildAt(i2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00f6  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r7, int r8) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.settings.theme.CarouselSpinner.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.selectedId >= 0) {
            this.f3234l = true;
            this.f3228f = true;
            this.f3226d = savedState.selectedId;
            this.f3225c = savedState.position;
            this.f3229g = 0;
            requestLayout();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.selectedId = m3251d();
        if (savedState.selectedId >= 0) {
            savedState.position = m3249c();
        } else {
            savedState.position = -1;
        }
        return savedState;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f3267y) {
            return;
        }
        super.requestLayout();
    }

    @Override // com.sec.chaton.settings.theme.CarouselAdapter
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f3264v != null) {
            this.f3264v.unregisterDataSetObserver(this.f3263F);
            m3272n();
        }
        this.f3264v = spinnerAdapter;
        this.f3241s = -1;
        this.f3242t = Long.MIN_VALUE;
        if (this.f3264v != null) {
            this.f3240r = this.f3239q;
            this.f3239q = this.f3264v.getCount();
            m3255h();
            this.f3263F = new C0513d(this);
            this.f3264v.registerDataSetObserver(this.f3263F);
            int i = this.f3239q > 0 ? 0 : -1;
            mo3237a(i);
            m3250c(i);
            if (this.f3239q == 0) {
                m3257j();
            }
        } else {
            m3255h();
            m3272n();
            m3257j();
        }
        requestLayout();
    }

    @Override // com.sec.chaton.settings.theme.CarouselAdapter
    public void setSelection(int i) {
        m3270c(i, false);
    }

    public void setSelection(int i, boolean z) {
        m3270c(i, z && this.f3223a <= i && i <= (this.f3223a + getChildCount()) - 1);
    }
}
