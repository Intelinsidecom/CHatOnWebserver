package com.sec.chaton.chat;

import android.view.View;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.bf */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0492bf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0477as f2086a;

    /* renamed from: b */
    private long f2087b;

    public ViewOnClickListenerC0492bf(ViewOnClickListenerC0477as viewOnClickListenerC0477as, long j) {
        this.f2086a = viewOnClickListenerC0477as;
        this.f2087b = j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2086a.f1968G.mo2590a(view, this.f2087b);
    }
}
