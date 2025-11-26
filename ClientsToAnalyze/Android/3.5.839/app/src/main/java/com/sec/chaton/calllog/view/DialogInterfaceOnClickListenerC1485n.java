package com.sec.chaton.calllog.view;

import android.content.DialogInterface;
import android.os.Message;

/* compiled from: CallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.n */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1485n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f5412a;

    /* renamed from: b */
    final /* synthetic */ CallLogFragment f5413b;

    DialogInterfaceOnClickListenerC1485n(CallLogFragment callLogFragment, int i) {
        this.f5413b = callLogFragment;
        this.f5412a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5413b.f5272p.sendMessage(Message.obtain(this.f5413b.f5272p, 8002, this.f5413b.f5276t.get(this.f5412a)));
    }
}
