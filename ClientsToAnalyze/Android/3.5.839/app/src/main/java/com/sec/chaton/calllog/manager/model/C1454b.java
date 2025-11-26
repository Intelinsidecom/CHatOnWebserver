package com.sec.chaton.calllog.manager.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: CallLogData.java */
/* renamed from: com.sec.chaton.calllog.manager.model.b */
/* loaded from: classes.dex */
final class C1454b implements Parcelable.Creator {
    C1454b() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CallLogData createFromParcel(Parcel parcel) {
        return new CallLogData(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public Object[] newArray(int i) {
        return new CallLogData[i];
    }
}
