package com.sec.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import java.util.HashSet;

/* loaded from: classes.dex */
public class FastScrollableExpandableListView extends ExpandableListView {

    /* renamed from: a */
    private C1621i f5660a;

    /* renamed from: b */
    private AbsListView.OnScrollListener f5661b;

    /* renamed from: c */
    private HashSet f5662c;

    /* renamed from: d */
    private boolean f5663d;

    public FastScrollableExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5662c = new HashSet();
        this.f5663d = false;
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        super.setFastScrollEnabled(false);
        if (z) {
            if (this.f5660a == null) {
                this.f5660a = new C1621i(getContext(), this);
            }
        } else if (this.f5660a != null) {
            this.f5660a.m5906b();
            this.f5660a = null;
        }
        setOnScrollListener(this.f5661b);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f5660a != null) {
            this.f5660a.m5901a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        if (this.f5660a == null || !this.f5660a.m5907b(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f5660a != null) {
            this.f5660a.m5902a(canvas);
        }
        setVerticalScrollBarEnabled(this.f5660a == null || !this.f5660a.m5908c());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f5660a == null || !this.f5660a.m5905a(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f5661b = onScrollListener;
        super.setOnScrollListener(new C1616d(this));
    }

    /* renamed from: a */
    public boolean m5846a(String str) {
        boolean zContains = this.f5662c.contains(str);
        if (this.f5663d) {
            return !zContains;
        }
        return zContains;
    }

    /* renamed from: b */
    public boolean m5848b(String str) {
        return this.f5662c.contains(str);
    }

    public void setChildChecked(String str, boolean z) {
        if (z) {
            this.f5662c.add(str);
        } else {
            this.f5662c.remove(str);
        }
        invalidateViews();
    }

    /* renamed from: a */
    public int m5845a() {
        return this.f5662c.size();
    }

    /* renamed from: b */
    public HashSet m5847b() {
        return (HashSet) this.f5662c.clone();
    }

    /* renamed from: c */
    public String[] m5849c() {
        return (String[]) this.f5662c.toArray(new String[0]);
    }

    public void setChildCheckInverse(boolean z) {
        this.f5663d = z;
    }

    /* renamed from: d */
    public boolean m5850d() {
        return this.f5663d;
    }

    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new C1620h();
        HashSet checkedChildSet;
        boolean childCheckInverse;

        /* synthetic */ SavedState(Parcel parcel, C1616d c1616d) {
            this(parcel);
        }

        SavedState(Parcelable parcelable, HashSet hashSet, boolean z) {
            super(parcelable);
            this.checkedChildSet = hashSet;
            this.childCheckInverse = z;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.checkedChildSet = (HashSet) parcel.readSerializable();
            this.childCheckInverse = parcel.readInt() > 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeSerializable(this.checkedChildSet);
            parcel.writeInt(this.childCheckInverse ? 1 : 0);
        }

        public String toString() {
            return "FastScrollableExpandableListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " checkedChildSet=" + this.checkedChildSet + " childCheckInverse=" + this.childCheckInverse + "}";
        }
    }

    @Override // android.widget.ExpandableListView, android.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f5662c, this.f5663d);
    }

    @Override // android.widget.ExpandableListView, android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.checkedChildSet != null) {
            this.f5662c = savedState.checkedChildSet;
            this.f5663d = savedState.childCheckInverse;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f5660a != null) {
            this.f5660a.m5906b();
        }
    }
}
