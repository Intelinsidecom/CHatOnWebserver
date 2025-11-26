package com.sec.chaton.smsplugin.spam;

import android.view.View;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.ap */
/* loaded from: classes.dex */
class ViewOnClickListenerC3985ap implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberList f14426a;

    ViewOnClickListenerC3985ap(SetupSpamNumberList setupSpamNumberList) {
        this.f14426a = setupSpamNumberList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f14426a.f14370u == 1) {
            this.f14426a.softkeyLeftRun(null);
        }
    }
}
