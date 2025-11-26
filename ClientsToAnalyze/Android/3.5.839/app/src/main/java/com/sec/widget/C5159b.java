package com.sec.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.sec.widget.ChoicePanel;

/* compiled from: ChoicePanel.java */
/* renamed from: com.sec.widget.b */
/* loaded from: classes.dex */
final class C5159b implements Parcelable.Creator<ChoicePanel.SavedState> {
    C5159b() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChoicePanel.SavedState createFromParcel(Parcel parcel) {
        return new ChoicePanel.SavedState(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChoicePanel.SavedState[] newArray(int i) {
        return new ChoicePanel.SavedState[i];
    }
}
