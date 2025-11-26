package com.sec.chaton.calllog.view;

import android.content.DialogInterface;
import android.os.Message;

/* compiled from: CallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.p */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0876p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CallLogFragment f3470a;

    DialogInterfaceOnClickListenerC0876p(CallLogFragment callLogFragment) {
        this.f3470a = callLogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3470a.f3298o.sendMessage(Message.obtain(this.f3470a.f3298o, 8003, null));
    }
}
