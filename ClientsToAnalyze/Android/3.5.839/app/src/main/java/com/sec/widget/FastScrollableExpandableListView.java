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
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class FastScrollableExpandableListView extends ExpandableListView {

    /* renamed from: a */
    public boolean f18762a;

    /* renamed from: b */
    private C5173p f18763b;

    /* renamed from: c */
    private AbsListView.OnScrollListener f18764c;

    /* renamed from: d */
    private HashSet<String> f18765d;

    /* renamed from: e */
    private boolean f18766e;

    public FastScrollableExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18762a = false;
        this.f18765d = new HashSet<>();
        this.f18766e = false;
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        super.setFastScrollEnabled(false);
        if (z) {
            if (this.f18763b == null) {
                this.f18763b = new C5173p(getContext(), this);
            }
        } else if (this.f18763b != null) {
            this.f18763b.m19784b();
            this.f18763b = null;
        }
        setOnScrollListener(this.f18764c);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f18763b != null) {
            this.f18763b.m19779a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        if (this.f18763b == null || !this.f18763b.m19785b(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f18763b != null) {
            this.f18763b.m19780a(canvas);
        }
        setVerticalScrollBarEnabled(this.f18763b == null || !this.f18763b.m19786c());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f18763b == null || !this.f18763b.m19783a(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f18764c = onScrollListener;
        super.setOnScrollListener(new C5172o(this));
    }

    /* renamed from: a */
    public boolean m19639a(String str) {
        boolean zContains = this.f18765d.contains(str);
        if (this.f18766e) {
            return !zContains;
        }
        return zContains;
    }

    /* renamed from: a */
    public boolean m19640a(Set<String> set) {
        boolean z = true;
        Iterator<String> it = set.iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                boolean zContains = this.f18765d.contains(it.next());
                z = !zContains ? false : z2;
                if (!this.f18766e || !zContains) {
                }
            } else {
                return z2;
            }
        }
    }

    /* renamed from: a */
    public boolean m19641a(String[] strArr) {
        boolean z = true;
        for (String str : strArr) {
            boolean zContains = this.f18765d.contains(str);
            if (!zContains) {
                z = false;
            }
            if (!this.f18766e || !zContains) {
            }
        }
        return z;
    }

    /* renamed from: b */
    public boolean m19643b(String str) {
        return this.f18765d.contains(str);
    }

    public void setChildChecked(String str, boolean z) {
        if (z) {
            this.f18765d.add(str);
        } else {
            this.f18765d.remove(str);
        }
        invalidateViews();
    }

    /* renamed from: a */
    public int m19638a() {
        return this.f18765d.size();
    }

    /* renamed from: b */
    public HashSet<String> m19642b() {
        return (HashSet) this.f18765d.clone();
    }

    /* renamed from: c */
    public String[] m19644c() {
        return (String[]) this.f18765d.toArray(new String[0]);
    }

    public void setChildCheckInverse(boolean z) {
        this.f18766e = z;
    }

    /* renamed from: d */
    public boolean m19645d() {
        return this.f18766e;
    }

    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C5175r();
        HashSet<String> checkedChildSet;
        boolean childCheckInverse;

        /* synthetic */ SavedState(Parcel parcel, C5172o c5172o) {
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
        return new SavedState(super.onSaveInstanceState(), this.f18765d, this.f18766e);
    }

    @Override // android.widget.ExpandableListView, android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.checkedChildSet != null) {
            this.f18765d = savedState.checkedChildSet;
            this.f18766e = savedState.childCheckInverse;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f18763b != null) {
            this.f18763b.m19784b();
        }
    }
}
