package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ej */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1683ej implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1677ed f6263a;

    DialogInterfaceOnClickListenerC1683ej(AsyncTaskC1677ed asyncTaskC1677ed) {
        this.f6263a = asyncTaskC1677ed;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
