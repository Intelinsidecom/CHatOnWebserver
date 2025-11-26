package com.sec.chaton.chat;

import android.view.View;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.c */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0586c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0603t f2013a;

    /* renamed from: b */
    private long f2014b;

    /* renamed from: c */
    private boolean f2015c;

    public ViewOnClickListenerC0586c(ViewOnClickListenerC0603t viewOnClickListenerC0603t, long j, boolean z) {
        this.f2013a = viewOnClickListenerC0603t;
        this.f2014b = j;
        this.f2015c = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2013a.f2085y.mo2691a(view, this.f2014b, this.f2015c);
    }
}
