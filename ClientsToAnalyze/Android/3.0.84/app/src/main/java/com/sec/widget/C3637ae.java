package com.sec.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.sec.widget.FastScrollableExpandableListView;

/* compiled from: FastScrollableExpandableListView.java */
/* renamed from: com.sec.widget.ae */
/* loaded from: classes.dex */
final class C3637ae implements Parcelable.Creator<FastScrollableExpandableListView.SavedState> {
    C3637ae() {
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
