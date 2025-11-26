package com.sec.chaton.util;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: ShareUtil.java */
/* renamed from: com.sec.chaton.util.ch */
/* loaded from: classes.dex */
final class ViewOnClickListenerC4870ch implements View.OnClickListener {
    ViewOnClickListenerC4870ch() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4809aa.m18105a("TrunkShareCheckPopup", Boolean.valueOf(((CheckBox) view).isChecked()));
    }
}
