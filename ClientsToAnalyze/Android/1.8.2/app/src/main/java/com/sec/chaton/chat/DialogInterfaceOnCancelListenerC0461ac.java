package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ac */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0461ac implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ long f1926a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f1927b;

    DialogInterfaceOnCancelListenerC0461ac(ChatFragment chatFragment, long j) {
        this.f1927b = chatFragment;
        this.f1926a = j;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f1927b.mo2590a((View) null, this.f1926a);
    }
}
