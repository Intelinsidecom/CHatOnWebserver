package com.sec.chaton.chat;

import android.view.View;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.al */
/* loaded from: classes.dex */
class ViewOnClickListenerC0536al implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f1885a;

    /* renamed from: b */
    final /* synthetic */ String f1886b;

    /* renamed from: c */
    final /* synthetic */ ViewOnClickListenerC0603t f1887c;

    ViewOnClickListenerC0536al(ViewOnClickListenerC0603t viewOnClickListenerC0603t, String str, String str2) {
        this.f1887c = viewOnClickListenerC0603t;
        this.f1885a = str;
        this.f1886b = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1887c.f2085y.mo2693a(view, this.f1885a, this.f1886b);
    }
}
