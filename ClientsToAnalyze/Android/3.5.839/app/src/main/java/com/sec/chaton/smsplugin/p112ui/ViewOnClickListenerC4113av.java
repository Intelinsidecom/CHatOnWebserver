package com.sec.chaton.smsplugin.p112ui;

import android.view.View;

/* compiled from: MessageListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.av */
/* loaded from: classes.dex */
class ViewOnClickListenerC4113av implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MessageListItem f15333a;

    /* renamed from: b */
    final /* synthetic */ C4110as f15334b;

    ViewOnClickListenerC4113av(C4110as c4110as, MessageListItem messageListItem) {
        this.f15334b = c4110as;
        this.f15333a = messageListItem;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((PluginComposeMessageActivity) this.f15334b.f15320p).m16119a(this.f15333a, this.f15333a.m15834i());
    }
}
