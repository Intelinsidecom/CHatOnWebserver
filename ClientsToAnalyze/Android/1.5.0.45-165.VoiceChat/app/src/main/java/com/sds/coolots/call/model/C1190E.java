package com.sds.coolots.call.model;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.sds.coolots.call.model.E */
/* loaded from: classes.dex */
class C1190E implements Parcelable.Creator {
    C1190E() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Destination createFromParcel(Parcel parcel) {
        return new Destination(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public Object[] newArray(int i) {
        return new Destination[i];
    }
}
