package com.sec.chaton.chat;

import android.view.View;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.ax */
/* loaded from: classes.dex */
class ViewOnClickListenerC0482ax implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2015a;

    /* renamed from: b */
    final /* synthetic */ String f2016b;

    /* renamed from: c */
    final /* synthetic */ ViewOnClickListenerC0477as f2017c;

    ViewOnClickListenerC0482ax(ViewOnClickListenerC0477as viewOnClickListenerC0477as, String str, String str2) {
        this.f2017c = viewOnClickListenerC0477as;
        this.f2015a = str;
        this.f2016b = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2017c.f1968G.mo2594a(view, this.f2015a, this.f2016b);
    }
}
