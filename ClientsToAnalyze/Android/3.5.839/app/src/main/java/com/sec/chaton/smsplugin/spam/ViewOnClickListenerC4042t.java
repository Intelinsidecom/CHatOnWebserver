package com.sec.chaton.smsplugin.spam;

import android.view.View;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.t */
/* loaded from: classes.dex */
class ViewOnClickListenerC4042t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamKeywordList f14556a;

    ViewOnClickListenerC4042t(SetupSpamKeywordList setupSpamKeywordList) {
        this.f14556a = setupSpamKeywordList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean zIsChecked = this.f14556a.f14309j.isChecked();
        for (int i = 0; i < this.f14556a.f14308i.getCount() - this.f14556a.f14311l; i++) {
            this.f14556a.f14308i.setItemChecked(this.f14556a.f14311l + i, !zIsChecked);
        }
        this.f14556a.f14309j.setChecked(zIsChecked ? false : true);
        this.f14556a.m15335e();
    }
}
