package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ad */
/* loaded from: classes.dex */
class ViewOnClickListenerC1557ad implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1505a f5958a;

    /* renamed from: b */
    final /* synthetic */ CheckBox f5959b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f5960c;

    ViewOnClickListenerC1557ad(ChatFragment chatFragment, C1505a c1505a, CheckBox checkBox) {
        this.f5960c = chatFragment;
        this.f5958a = c1505a;
        this.f5959b = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f5958a != null) {
            this.f5960c.m8076b(this.f5958a.m8356a(), this.f5959b.isChecked());
        }
    }
}
