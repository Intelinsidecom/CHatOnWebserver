package com.renren.android.feed;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: FeedPublishRequestParam.java */
/* renamed from: com.renren.android.feed.a */
/* loaded from: classes.dex */
final class C0725a implements Parcelable.Creator<FeedPublishRequestParam> {
    C0725a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FeedPublishRequestParam createFromParcel(Parcel parcel) {
        return new FeedPublishRequestParam(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FeedPublishRequestParam[] newArray(int i) {
        return new FeedPublishRequestParam[i];
    }
}
