package com.sec.chaton.multimedia.multisend;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: PreviewData.java */
/* renamed from: com.sec.chaton.multimedia.multisend.o */
/* loaded from: classes.dex */
final class C1912o implements Parcelable.Creator<PreviewData> {
    C1912o() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PreviewData createFromParcel(Parcel parcel) {
        return new PreviewData(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PreviewData[] newArray(int i) {
        return new PreviewData[i];
    }
}
