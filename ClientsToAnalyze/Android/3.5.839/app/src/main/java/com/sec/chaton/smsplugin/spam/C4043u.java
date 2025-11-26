package com.sec.chaton.smsplugin.spam;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.u */
/* loaded from: classes.dex */
class C4043u implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamKeywordList f14557a;

    C4043u(SetupSpamKeywordList setupSpamKeywordList) {
        this.f14557a = setupSpamKeywordList;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f14557a.f14305f == 1) {
            this.f14557a.m15335e();
        }
    }
}
