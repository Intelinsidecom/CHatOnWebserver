package com.sec.chaton.chat;

import android.view.View;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.v */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0605v implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0603t f2087a;

    /* renamed from: b */
    private long f2088b;

    public ViewOnClickListenerC0605v(ViewOnClickListenerC0603t viewOnClickListenerC0603t, long j) {
        this.f2087a = viewOnClickListenerC0603t;
        this.f2088b = j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2087a.f2085y.mo2689a(view, this.f2088b);
    }
}
