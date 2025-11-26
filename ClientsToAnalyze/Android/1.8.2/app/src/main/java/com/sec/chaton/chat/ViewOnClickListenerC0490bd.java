package com.sec.chaton.chat;

import android.view.View;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.bd */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0490bd implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0477as f2079a;

    /* renamed from: b */
    private long f2080b;

    /* renamed from: c */
    private boolean f2081c;

    public ViewOnClickListenerC0490bd(ViewOnClickListenerC0477as viewOnClickListenerC0477as, long j, boolean z) {
        this.f2079a = viewOnClickListenerC0477as;
        this.f2080b = j;
        this.f2081c = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2079a.f1968G.mo2592a(view, this.f2080b, this.f2081c);
    }
}
