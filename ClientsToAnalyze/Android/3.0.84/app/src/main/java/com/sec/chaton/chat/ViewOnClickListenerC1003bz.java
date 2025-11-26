package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.p025d.C1328f;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bz */
/* loaded from: classes.dex */
class ViewOnClickListenerC1003bz implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4077a;

    ViewOnClickListenerC1003bz(ChatFragment chatFragment) {
        this.f4077a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4077a.m5021v();
        new C1328f(this.f4077a.f3522X).m5706a(this.f4077a.f3704s, 1);
    }
}
