package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Fragment.java */
/* renamed from: android.support.v4.app.ae */
/* loaded from: classes.dex */
final class C0019ae implements Parcelable.Creator<FragmentState> {
    C0019ae() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FragmentState createFromParcel(Parcel parcel) {
        return new FragmentState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FragmentState[] newArray(int i) {
        return new FragmentState[i];
    }
}
