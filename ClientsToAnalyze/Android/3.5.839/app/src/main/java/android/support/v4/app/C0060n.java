package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: BackStackRecord.java */
/* renamed from: android.support.v4.app.n */
/* loaded from: classes.dex */
final class C0060n implements Parcelable.Creator<BackStackState> {
    C0060n() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BackStackState createFromParcel(Parcel parcel) {
        return new BackStackState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BackStackState[] newArray(int i) {
        return new BackStackState[i];
    }
}
