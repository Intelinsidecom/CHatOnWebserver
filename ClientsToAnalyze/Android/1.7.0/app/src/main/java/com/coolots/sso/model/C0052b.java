package com.coolots.sso.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ChatONCallStartInfo.java */
/* renamed from: com.coolots.sso.model.b */
/* loaded from: classes.dex */
final class C0052b implements Parcelable.Creator {
    C0052b() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChatONCallStartInfo createFromParcel(Parcel parcel) {
        return new ChatONCallStartInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChatONCallStartInfo[] newArray(int i) {
        return new ChatONCallStartInfo[i];
    }
}
