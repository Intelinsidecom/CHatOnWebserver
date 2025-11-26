package com.sec.chaton.chat;

import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC0529ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1879a;

    ViewOnClickListenerC0529ae(ChatFragment chatFragment) {
        this.f1879a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1879a.f1794ad.setSelection(this.f1879a.f1794ad.getCount() - 1);
        this.f1879a.m2705e();
    }
}
