package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0987bj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4057a;

    DialogInterfaceOnClickListenerC0987bj(ChatFragment chatFragment) {
        this.f4057a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GlobalApplication.m6454c(CommonApplication.m11493l());
    }
}
