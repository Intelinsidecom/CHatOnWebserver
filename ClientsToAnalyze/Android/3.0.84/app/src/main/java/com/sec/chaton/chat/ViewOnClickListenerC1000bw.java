package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.p025d.C1330h;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bw */
/* loaded from: classes.dex */
class ViewOnClickListenerC1000bw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4074a;

    ViewOnClickListenerC1000bw(ChatFragment chatFragment) {
        this.f4074a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4074a.m5021v();
        new C1330h(this.f4074a.f3522X).m5730b(this.f4074a.f3704s);
    }
}
