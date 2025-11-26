package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.widget.SlidingPaneLayout;

/* compiled from: SlidingPaneLayout.java */
/* renamed from: android.support.v4.widget.ah */
/* loaded from: classes.dex */
final class C0233ah implements Parcelable.Creator<SlidingPaneLayout.SavedState> {
    C0233ah() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SlidingPaneLayout.SavedState createFromParcel(Parcel parcel) {
        return new SlidingPaneLayout.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SlidingPaneLayout.SavedState[] newArray(int i) {
        return new SlidingPaneLayout.SavedState[i];
    }
}
