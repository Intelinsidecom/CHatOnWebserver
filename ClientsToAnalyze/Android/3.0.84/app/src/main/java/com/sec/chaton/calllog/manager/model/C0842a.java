package com.sec.chaton.calllog.manager.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: CallLogDBData.java */
/* renamed from: com.sec.chaton.calllog.manager.model.a */
/* loaded from: classes.dex */
final class C0842a implements Parcelable.Creator {
    C0842a() {
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
