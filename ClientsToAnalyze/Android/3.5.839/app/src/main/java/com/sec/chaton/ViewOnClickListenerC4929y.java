package com.sec.chaton;

import android.view.View;

/* compiled from: EOSPopupActivity.java */
/* renamed from: com.sec.chaton.y */
/* loaded from: classes.dex */
class ViewOnClickListenerC4929y implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EOSPopupActivity f17990a;

    ViewOnClickListenerC4929y(EOSPopupActivity eOSPopupActivity) {
        this.f17990a = eOSPopupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f17990a.f1927p) {
            this.f17990a.setResult(11);
        }
        this.f17990a.finish();
    }
}
