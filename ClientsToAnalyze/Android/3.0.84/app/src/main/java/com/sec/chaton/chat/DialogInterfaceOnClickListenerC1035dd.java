package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1035dd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1033db f4142a;

    DialogInterfaceOnClickListenerC1035dd(AsyncTaskC1033db asyncTaskC1033db) {
        this.f4142a = asyncTaskC1033db;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
