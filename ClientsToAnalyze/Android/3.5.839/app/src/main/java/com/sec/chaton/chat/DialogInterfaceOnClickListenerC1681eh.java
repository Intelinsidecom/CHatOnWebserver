package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.eh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1681eh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1677ed f6259a;

    DialogInterfaceOnClickListenerC1681eh(AsyncTaskC1677ed asyncTaskC1677ed) {
        this.f6259a = asyncTaskC1677ed;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
