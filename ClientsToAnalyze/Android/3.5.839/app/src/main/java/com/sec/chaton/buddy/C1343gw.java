package com.sec.chaton.buddy;

import android.os.Parcel;
import android.os.Parcelable;
import com.sec.chaton.buddy.BuddyProfileImageViewFragment;

/* compiled from: BuddyProfileImageViewFragment.java */
/* renamed from: com.sec.chaton.buddy.gw */
/* loaded from: classes.dex */
final class C1343gw implements Parcelable.Creator<BuddyProfileImageViewFragment.ProfileImageItem> {
    C1343gw() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BuddyProfileImageViewFragment.ProfileImageItem createFromParcel(Parcel parcel) {
        return new BuddyProfileImageViewFragment.ProfileImageItem(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BuddyProfileImageViewFragment.ProfileImageItem[] newArray(int i) {
        return new BuddyProfileImageViewFragment.ProfileImageItem[i];
    }
}
