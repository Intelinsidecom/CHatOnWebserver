package com.coolots.sso.calllog;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.coolots.sso.calllog.a */
/* loaded from: classes.dex */
class C0423a implements Parcelable.Creator {
    C0423a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChatONCallLogData createFromParcel(Parcel parcel) {
        return new ChatONCallLogData(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public Object[] newArray(int i) {
        return new ChatONCallLogData[i];
    }
}
