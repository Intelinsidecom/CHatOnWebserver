package com.sec.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.sec.widget.CustomDatePicker;

/* compiled from: CustomDatePicker.java */
/* renamed from: com.sec.widget.o */
/* loaded from: classes.dex */
final class C3681o implements Parcelable.Creator<CustomDatePicker.SavedState> {
    C3681o() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CustomDatePicker.SavedState createFromParcel(Parcel parcel) {
        return new CustomDatePicker.SavedState(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CustomDatePicker.SavedState[] newArray(int i) {
        return new CustomDatePicker.SavedState[i];
    }
}
