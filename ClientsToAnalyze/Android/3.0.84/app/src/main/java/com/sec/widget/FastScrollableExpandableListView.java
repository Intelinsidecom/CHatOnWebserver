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
    public boolean f13395a;

    /* renamed from: b */
    private C3635ac f13396b;

    /* renamed from: c */
    private AbsListView.OnScrollListener f13397c;

    /* renamed from: d */
    private HashSet<String> f13398d;

    /* renamed from: e */
    private boolean f13399e;

    public FastScrollableExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13395a = false;
        this.f13398d = new HashSet<>();
        this.f13399e = false;
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        super.setFastScrollEnabled(false);
        if (z) {
            if (this.f13396b == null) {
                this.f13396b = new C3635ac(getContext(), this);
            }
        } else if (this.f13396b != null) {
            this.f13396b.m13184b();
            this.f13396b = null;
        }
        setOnScrollListener(this.f13397c);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f13396b != null) {
            this.f13396b.m13179a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        if (this.f13396b == null || !this.f13396b.m13185b(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f13396b != null) {
            this.f13396b.m13180a(canvas);
        }
        setVerticalScrollBarEnabled(this.f13396b == null || !this.f13396b.m13186c());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f13396b == null || !this.f13396b.m13183a(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f13397c = onScrollListener;
        super.setOnScrollListener(new C3634ab(this));
    }

    /* renamed from: a */
    public boolean m13107a(String str) {
        boolean zContains = this.f13398d.contains(str);
        if (this.f13399e) {
            return !zContains;
        }
        return zContains;
    }

    /* renamed from: a */
    public boolean m13108a(String[] strArr) {
        boolean z = true;
        for (String str : strArr) {
            boolean zContains = this.f13398d.contains(str);
            if (!zContains) {
                z = false;
            }
            if (!this.f13399e || !zContains) {
            }
        }
        return z;
    }

    /* renamed from: b */
    public boolean m13110b(String str) {
        return this.f13398d.contains(str);
    }

    public void setChildChecked(String str, boolean z) {
        if (z) {
            this.f13398d.add(str);
        } else {
            this.f13398d.remove(str);
        }
        invalidateViews();
    }

    /* renamed from: a */
    public int m13106a() {
        return this.f13398d.size();
    }

    /* renamed from: b */
    public HashSet<String> m13109b() {
        return (HashSet) this.f13398d.clone();
    }

    /* renamed from: c */
    public String[] m13111c() {
        return (String[]) this.f13398d.toArray(new String[0]);
    }

    public void setChildCheckInverse(boolean z) {
        this.f13399e = z;
    }

    /* renamed from: d */
    public boolean m13112d() {
        return this.f13399e;
    }

    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C3637ae();
        HashSet<String> checkedChildSet;
        boolean childCheckInverse;

        /* synthetic */ SavedState(Parcel parcel, C3634ab c3634ab) {
            this(parcel);
        }

        SavedState(Parcelable parcelable, HashSet<String> hashSet, boolean z) {
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
        return new SavedState(super.onSaveInstanceState(), this.f13398d, this.f13399e);
    }

    @Override // android.widget.ExpandableListView, android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.checkedChildSet != null) {
            this.f13398d = savedState.checkedChildSet;
            this.f13399e = savedState.childCheckInverse;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f13396b != null) {
            this.f13396b.m13184b();
        }
    }
}
