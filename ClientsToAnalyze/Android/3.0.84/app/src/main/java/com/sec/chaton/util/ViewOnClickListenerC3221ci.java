package com.sec.chaton.util;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: ShareUtil.java */
/* renamed from: com.sec.chaton.util.ci */
/* loaded from: classes.dex */
final class ViewOnClickListenerC3221ci implements View.OnClickListener {
    ViewOnClickListenerC3221ci() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3159aa.m10963a("TrunkShareCheckPopup", Boolean.valueOf(((CheckBox) view).isChecked()));
    }
}
