package com.sec.chaton.chat;

import android.view.View;

/* compiled from: ChatInfoAdapter.java */
/* renamed from: com.sec.chaton.chat.eq */
/* loaded from: classes.dex */
class ViewOnClickListenerC1690eq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1692es f6278a;

    /* renamed from: b */
    final /* synthetic */ C1688eo f6279b;

    ViewOnClickListenerC1690eq(C1688eo c1688eo, C1692es c1692es) {
        this.f6279b = c1688eo;
        this.f6278a = c1692es;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f6279b.f6274d != null) {
            this.f6279b.f6274d.mo8327a(this.f6278a.m8525a(), this.f6278a.m8526b());
        }
    }
}
