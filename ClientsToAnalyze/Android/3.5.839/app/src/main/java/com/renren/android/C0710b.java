package com.renren.android;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AccessTokenManager.java */
/* renamed from: com.renren.android.b */
/* loaded from: classes.dex */
final class C0710b implements Parcelable.Creator<AccessTokenManager> {
    C0710b() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AccessTokenManager createFromParcel(Parcel parcel) {
        return new AccessTokenManager(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AccessTokenManager[] newArray(int i) {
        return new AccessTokenManager[i];
    }
}
