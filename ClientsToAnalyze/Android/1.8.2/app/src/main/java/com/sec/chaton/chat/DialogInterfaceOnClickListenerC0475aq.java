package com.sec.chaton.chat;

import android.content.DialogInterface;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.aq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0475aq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC0473ao f1958a;

    DialogInterfaceOnClickListenerC0475aq(AsyncTaskC0473ao asyncTaskC0473ao) {
        this.f1958a = asyncTaskC0473ao;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
