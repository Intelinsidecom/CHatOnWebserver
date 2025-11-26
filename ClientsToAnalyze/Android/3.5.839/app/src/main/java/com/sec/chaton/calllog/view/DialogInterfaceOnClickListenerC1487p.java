package com.sec.chaton.calllog.view;

import android.content.DialogInterface;
import android.os.Message;

/* compiled from: CallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.p */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1487p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CallLogFragment f5415a;

    DialogInterfaceOnClickListenerC1487p(CallLogFragment callLogFragment) {
        this.f5415a = callLogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5415a.f5272p.sendMessage(Message.obtain(this.f5415a.f5272p, 8003, null));
    }
}
