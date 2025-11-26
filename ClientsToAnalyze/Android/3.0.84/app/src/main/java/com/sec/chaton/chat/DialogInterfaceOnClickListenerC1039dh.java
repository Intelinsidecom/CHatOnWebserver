package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1039dh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1033db f4149a;

    DialogInterfaceOnClickListenerC1039dh(AsyncTaskC1033db asyncTaskC1033db) {
        this.f4149a = asyncTaskC1033db;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
