package com.sec.chaton.msgsend;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ChatONMsgEntity.java */
/* renamed from: com.sec.chaton.msgsend.h */
/* loaded from: classes.dex */
final class C2700h implements Parcelable.Creator<ChatONMsgEntity> {
    C2700h() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChatONMsgEntity createFromParcel(Parcel parcel) {
        return new ChatONMsgEntity(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChatONMsgEntity[] newArray(int i) {
        return new ChatONMsgEntity[i];
    }
}
