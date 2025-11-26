package com.sec.chaton.smsplugin.spam;

import android.view.View;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.ad */
/* loaded from: classes.dex */
class ViewOnClickListenerC3973ad implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4017bu f14408a;

    /* renamed from: b */
    final /* synthetic */ C3971ab f14409b;

    ViewOnClickListenerC3973ad(C3971ab c3971ab, C4017bu c4017bu) {
        this.f14409b = c3971ab;
        this.f14408a = c4017bu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.f14409b.f14402a.f14301b.size() || ((C4017bu) this.f14409b.f14402a.f14301b.get(i)).m15458c().equals(this.f14408a.m15458c())) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        this.f14409b.f14402a.f14306g = i;
        this.f14409b.f14402a.m15334d();
    }
}
