package com.sec.chaton.smsplugin.spam;

import android.view.View;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.q */
/* loaded from: classes.dex */
class ViewOnClickListenerC4039q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamKeywordList f14553a;

    ViewOnClickListenerC4039q(SetupSpamKeywordList setupSpamKeywordList) {
        this.f14553a = setupSpamKeywordList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f14553a.f14305f == 1) {
            this.f14553a.softkeyLeftRun(null);
        }
    }
}
