package com.sec.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.sec.widget.FastScrollableExpandableListView;

/* compiled from: FastScrollableExpandableListView.java */
/* renamed from: com.sec.widget.r */
/* loaded from: classes.dex */
final class C5175r implements Parcelable.Creator<FastScrollableExpandableListView.SavedState> {
    C5175r() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FastScrollableExpandableListView.SavedState createFromParcel(Parcel parcel) {
        return new FastScrollableExpandableListView.SavedState(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FastScrollableExpandableListView.SavedState[] newArray(int i) {
        return new FastScrollableExpandableListView.SavedState[i];
    }
}
