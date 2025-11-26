package com.renren.android;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Renren.java */
/* renamed from: com.renren.android.d */
/* loaded from: classes.dex */
final class C0722d implements Parcelable.Creator<Renren> {
    C0722d() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Renren createFromParcel(Parcel parcel) {
        return new Renren(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Renren[] newArray(int i) {
        return new Renren[i];
    }
}
