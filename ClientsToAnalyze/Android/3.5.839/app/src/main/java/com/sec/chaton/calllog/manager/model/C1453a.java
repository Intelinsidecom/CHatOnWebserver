package com.sec.chaton.calllog.manager.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: CallLogDBData.java */
/* renamed from: com.sec.chaton.calllog.manager.model.a */
/* loaded from: classes.dex */
final class C1453a implements Parcelable.Creator {
    C1453a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CallLogDBData createFromParcel(Parcel parcel) {
        return new CallLogDBData(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public Object[] newArray(int i) {
        return new CallLogDBData[i];
    }
}
