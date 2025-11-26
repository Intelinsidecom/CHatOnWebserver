package com.sec.chaton.chat;

import android.view.View;

/* compiled from: ChatActivity.java */
/* renamed from: com.sec.chaton.chat.p */
/* loaded from: classes.dex */
class ViewOnClickListenerC0599p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatActivity f2041a;

    ViewOnClickListenerC0599p(ChatActivity chatActivity) {
        this.f2041a = chatActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2041a.f1701a.setCurrentTabByTag("chatroom");
        this.f2041a.m2597c();
    }
}
