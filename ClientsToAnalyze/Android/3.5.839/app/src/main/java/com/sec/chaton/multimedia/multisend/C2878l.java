package com.sec.chaton.multimedia.multisend;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: PreviewData.java */
/* renamed from: com.sec.chaton.multimedia.multisend.l */
/* loaded from: classes.dex */
final class C2878l implements Parcelable.Creator<PreviewData> {
    C2878l() {
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
