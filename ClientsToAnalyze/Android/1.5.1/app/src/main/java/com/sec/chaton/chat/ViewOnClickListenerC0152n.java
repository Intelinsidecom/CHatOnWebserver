package com.sec.chaton.chat;

import android.view.View;

/* renamed from: com.sec.chaton.chat.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC0152n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f966a;

    /* renamed from: b */
    final /* synthetic */ String f967b;

    /* renamed from: c */
    final /* synthetic */ ChatListAdapter f968c;

    ViewOnClickListenerC0152n(ChatListAdapter chatListAdapter, String str, String str2) {
        this.f968c = chatListAdapter;
        this.f966a = str;
        this.f967b = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f968c.f838H.mo762a(view, this.f966a, this.f967b);
    }
}
