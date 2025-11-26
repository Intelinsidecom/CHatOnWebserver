package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bi */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0986bi implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4056a;

    DialogInterfaceOnClickListenerC0986bi(ChatFragment chatFragment) {
        this.f4056a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GlobalApplication.m6449a(CommonApplication.m11493l());
    }
}
