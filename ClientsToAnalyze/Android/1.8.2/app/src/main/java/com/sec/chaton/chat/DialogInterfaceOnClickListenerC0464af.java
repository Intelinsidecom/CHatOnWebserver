package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0464af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1931a;

    DialogInterfaceOnClickListenerC0464af(ChatFragment chatFragment) {
        this.f1931a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GlobalApplication.m3258a(GlobalApplication.m3260b());
    }
}
