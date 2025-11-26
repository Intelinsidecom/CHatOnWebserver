package com.sec.chaton.buddy;

import android.os.Parcel;
import android.os.Parcelable;
import com.sec.chaton.buddy.BuddyProfileImageViewFragment;

/* compiled from: BuddyProfileImageViewFragment.java */
/* renamed from: com.sec.chaton.buddy.fp */
/* loaded from: classes.dex */
final class C0705fp implements Parcelable.Creator<BuddyProfileImageViewFragment.ProfileImageItem> {
    C0705fp() {
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
