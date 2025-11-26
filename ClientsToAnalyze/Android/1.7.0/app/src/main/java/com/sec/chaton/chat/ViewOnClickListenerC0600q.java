package com.sec.chaton.chat;

import android.view.View;

/* compiled from: ChatActivity.java */
/* renamed from: com.sec.chaton.chat.q */
/* loaded from: classes.dex */
class ViewOnClickListenerC0600q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatActivity f2042a;

    ViewOnClickListenerC0600q(ChatActivity chatActivity) {
        this.f2042a = chatActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2042a.f1701a.setCurrentTabByTag("trunk");
        this.f2042a.m2592a();
        this.f2042a.m2600d(this.f2042a.f1716p);
    }
}
