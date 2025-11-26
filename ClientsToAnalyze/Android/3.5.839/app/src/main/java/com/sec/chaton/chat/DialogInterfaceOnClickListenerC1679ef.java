package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ef */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1679ef implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1677ed f6256a;

    DialogInterfaceOnClickListenerC1679ef(AsyncTaskC1677ed asyncTaskC1677ed) {
        this.f6256a = asyncTaskC1677ed;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
