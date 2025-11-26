package com.sec.chaton.calllog.view;

import android.content.DialogInterface;
import android.os.Message;

/* compiled from: CallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.n */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0874n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f3467a;

    /* renamed from: b */
    final /* synthetic */ CallLogFragment f3468b;

    DialogInterfaceOnClickListenerC0874n(CallLogFragment callLogFragment, int i) {
        this.f3468b = callLogFragment;
        this.f3467a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3468b.f3298o.sendMessage(Message.obtain(this.f3468b.f3298o, 8002, this.f3468b.f3302s.get(this.f3467a)));
    }
}
