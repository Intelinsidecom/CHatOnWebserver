package com.sec.chaton.smsplugin.spam;

import android.view.View;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.aq */
/* loaded from: classes.dex */
class ViewOnClickListenerC3986aq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberList f14427a;

    ViewOnClickListenerC3986aq(SetupSpamNumberList setupSpamNumberList) {
        this.f14427a = setupSpamNumberList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f14427a.f14356M != null) {
            this.f14427a.f14356M.setEnabled(false);
        }
        if (this.f14427a.f14370u == 1) {
            this.f14427a.softkeyRightRun(null);
        }
    }
}
