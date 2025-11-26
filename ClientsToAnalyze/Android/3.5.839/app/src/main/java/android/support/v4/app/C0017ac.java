package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: FragmentManager.java */
/* renamed from: android.support.v4.app.ac */
/* loaded from: classes.dex */
final class C0017ac implements Parcelable.Creator<FragmentManagerState> {
    C0017ac() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FragmentManagerState createFromParcel(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FragmentManagerState[] newArray(int i) {
        return new FragmentManagerState[i];
    }
}
