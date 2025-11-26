package com.sec.chaton.chat;

import android.widget.CompoundButton;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cg */
/* loaded from: classes.dex */
class C1011cg implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ C1028cx f4085a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f4086b;

    C1011cg(ChatFragment chatFragment, C1028cx c1028cx) {
        this.f4086b = chatFragment;
        this.f4085a = c1028cx;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f4086b.m4764a(this.f4085a, z);
    }
}
