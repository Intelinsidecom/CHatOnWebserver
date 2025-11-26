package com.sec.chaton.chat;

import android.widget.CompoundButton;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ay */
/* loaded from: classes.dex */
class C0549ay implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1909a;

    C0549ay(ChatFragment chatFragment) {
        this.f1909a = chatFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f1909a.f1823bG.edit().putBoolean("Motion do not ask", z).commit();
    }
}
