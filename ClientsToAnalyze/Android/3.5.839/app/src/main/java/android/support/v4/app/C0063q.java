package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;

/* compiled from: Fragment.java */
/* renamed from: android.support.v4.app.q */
/* loaded from: classes.dex */
final class C0063q implements Parcelable.Creator<Fragment.SavedState> {
    C0063q() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Fragment.SavedState createFromParcel(Parcel parcel) {
        return new Fragment.SavedState(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Fragment.SavedState[] newArray(int i) {
        return new Fragment.SavedState[i];
    }
}
