package com.sds.coolots.common.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ParcelBitmap implements Parcelable {

    /* renamed from: a */
    public static final Parcelable.Creator f3055a = new C1259a();

    /* renamed from: b */
    private Bitmap f3056b;

    public ParcelBitmap(Bitmap bitmap) {
        this.f3056b = null;
        if (bitmap != null) {
            this.f3056b = Bitmap.createBitmap(bitmap);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Bitmap getBitmap() {
        return this.f3056b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.f3056b != null) {
            this.f3056b.writeToParcel(parcel, i);
        }
    }
}
