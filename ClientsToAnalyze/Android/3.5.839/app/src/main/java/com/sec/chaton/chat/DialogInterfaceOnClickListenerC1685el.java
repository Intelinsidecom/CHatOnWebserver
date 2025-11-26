package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.el */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1685el implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1677ed f6267a;

    DialogInterfaceOnClickListenerC1685el(AsyncTaskC1677ed asyncTaskC1677ed) {
        this.f6267a = asyncTaskC1677ed;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
