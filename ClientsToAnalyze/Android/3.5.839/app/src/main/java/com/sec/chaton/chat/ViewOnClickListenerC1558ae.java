package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC1558ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1505a f5961a;

    /* renamed from: b */
    final /* synthetic */ CheckBox f5962b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f5963c;

    ViewOnClickListenerC1558ae(ChatFragment chatFragment, C1505a c1505a, CheckBox checkBox) {
        this.f5963c = chatFragment;
        this.f5961a = c1505a;
        this.f5962b = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f5961a != null) {
            this.f5963c.m8076b(this.f5961a.m8356a(), this.f5962b.isChecked());
        }
    }
}
