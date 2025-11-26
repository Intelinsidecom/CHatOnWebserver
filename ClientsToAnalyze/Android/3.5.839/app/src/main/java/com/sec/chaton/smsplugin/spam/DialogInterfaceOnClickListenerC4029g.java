package com.sec.chaton.smsplugin.spam;

import android.content.DialogInterface;

/* compiled from: ManageSpamMessages.java */
/* renamed from: com.sec.chaton.smsplugin.spam.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4029g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f14530a;

    /* renamed from: b */
    final /* synthetic */ long f14531b;

    /* renamed from: c */
    final /* synthetic */ ManageSpamMessages f14532c;

    DialogInterfaceOnClickListenerC4029g(ManageSpamMessages manageSpamMessages, String str, long j) {
        this.f14532c = manageSpamMessages;
        this.f14530a = str;
        this.f14531b = j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f14532c.m15297b(2);
        this.f14532c.m15291a(this.f14530a, this.f14531b);
        this.f14532c.m15296b();
        dialogInterface.dismiss();
    }
}
