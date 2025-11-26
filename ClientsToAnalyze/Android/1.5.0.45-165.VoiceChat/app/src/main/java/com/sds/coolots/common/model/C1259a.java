package com.sds.coolots.common.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.sds.coolots.common.model.a */
/* loaded from: classes.dex */
class C1259a implements Parcelable.Creator {
    C1259a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelBitmap createFromParcel(Parcel parcel) {
        ParcelBitmap parcelBitmap = new ParcelBitmap(null);
        try {
            parcelBitmap.f3056b = (Bitmap) Bitmap.CREATOR.createFromParcel(parcel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parcelBitmap;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelBitmap[] newArray(int i) {
        return new ParcelBitmap[i];
    }
}
