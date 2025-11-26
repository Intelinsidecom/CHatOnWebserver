package com.sec.chaton.smsplugin.p112ui.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.sec.chaton.smsplugin.p112ui.widget.ChoicePanel;

/* compiled from: ChoicePanel.java */
/* renamed from: com.sec.chaton.smsplugin.ui.widget.b */
/* loaded from: classes.dex */
final class C4358b implements Parcelable.Creator<ChoicePanel.SavedState> {
    C4358b() {
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
