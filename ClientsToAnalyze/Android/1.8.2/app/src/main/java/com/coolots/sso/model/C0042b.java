package com.coolots.sso.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ChatONCallStateInfo.java */
/* renamed from: com.coolots.sso.model.b */
/* loaded from: classes.dex */
final class C0042b implements Parcelable.Creator {
    C0042b() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChatONCallStateInfo createFromParcel(Parcel parcel) {
        return new ChatONCallStateInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChatONCallStateInfo[] newArray(int i) {
        return new ChatONCallStateInfo[i];
    }
}
