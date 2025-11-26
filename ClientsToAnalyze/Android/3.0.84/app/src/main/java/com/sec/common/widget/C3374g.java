package com.sec.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.sec.common.widget.IcsAbsSpinner;

/* compiled from: IcsAbsSpinner.java */
/* renamed from: com.sec.common.widget.g */
/* loaded from: classes.dex */
final class C3374g implements Parcelable.Creator<IcsAbsSpinner.SavedState> {
    C3374g() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IcsAbsSpinner.SavedState createFromParcel(Parcel parcel) {
        return new IcsAbsSpinner.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IcsAbsSpinner.SavedState[] newArray(int i) {
        return new IcsAbsSpinner.SavedState[i];
    }
}
