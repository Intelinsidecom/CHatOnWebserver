package com.sec.chaton.smsplugin.spam;

import android.view.View;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.r */
/* loaded from: classes.dex */
class ViewOnClickListenerC4040r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamKeywordList f14554a;

    ViewOnClickListenerC4040r(SetupSpamKeywordList setupSpamKeywordList) {
        this.f14554a = setupSpamKeywordList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f14554a.f14319t != null) {
            this.f14554a.f14319t.setEnabled(false);
        }
        if (this.f14554a.f14305f == 1) {
            this.f14554a.softkeyRightRun(null);
        }
    }
}
