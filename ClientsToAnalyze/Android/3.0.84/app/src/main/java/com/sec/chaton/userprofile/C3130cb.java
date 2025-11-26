package com.sec.chaton.userprofile;

import android.os.Parcel;
import android.os.Parcelable;
import com.sec.chaton.userprofile.ProfileImageHistoryFragment;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.cb */
/* loaded from: classes.dex */
final class C3130cb implements Parcelable.Creator<ProfileImageHistoryFragment.ProfileImageItem> {
    C3130cb() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ProfileImageHistoryFragment.ProfileImageItem createFromParcel(Parcel parcel) {
        return new ProfileImageHistoryFragment.ProfileImageItem(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ProfileImageHistoryFragment.ProfileImageItem[] newArray(int i) {
        return new ProfileImageHistoryFragment.ProfileImageItem[i];
    }
}
