package com.sec.chaton.chat;

import android.widget.CompoundButton;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.au */
/* loaded from: classes.dex */
class C0545au implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1905a;

    C0545au(ChatFragment chatFragment) {
        this.f1905a = chatFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f1905a.f1823bG.edit().putBoolean("Motion do not ask", z).commit();
    }
}
