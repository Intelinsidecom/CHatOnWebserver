package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.df */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1037df implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1033db f4145a;

    DialogInterfaceOnClickListenerC1037df(AsyncTaskC1033db asyncTaskC1033db) {
        this.f4145a = asyncTaskC1033db;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
