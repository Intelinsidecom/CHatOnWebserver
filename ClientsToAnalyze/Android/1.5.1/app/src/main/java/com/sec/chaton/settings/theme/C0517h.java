package com.sec.chaton.settings.theme;

import android.os.Parcel;
import android.os.Parcelable;
import com.sec.chaton.settings.theme.CarouselSpinner;

/* renamed from: com.sec.chaton.settings.theme.h */
/* loaded from: classes.dex */
final class C0517h implements Parcelable.Creator {
    C0517h() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CarouselSpinner.SavedState createFromParcel(Parcel parcel) {
        return new CarouselSpinner.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CarouselSpinner.SavedState[] newArray(int i) {
        return new CarouselSpinner.SavedState[i];
    }
}
