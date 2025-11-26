package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0577bq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1994a;

    DialogInterfaceOnClickListenerC0577bq(ChatFragment chatFragment) {
        this.f1994a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GlobalApplication.m3102a(GlobalApplication.m3100a());
    }
}
