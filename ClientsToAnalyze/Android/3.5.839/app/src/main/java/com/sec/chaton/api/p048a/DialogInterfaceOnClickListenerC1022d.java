package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: ChatLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1022d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f3322a;

    /* renamed from: b */
    final /* synthetic */ Intent f3323b;

    /* renamed from: c */
    final /* synthetic */ C1021c f3324c;

    DialogInterfaceOnClickListenerC1022d(C1021c c1021c, Activity activity, Intent intent) {
        this.f3324c = c1021c;
        this.f3322a = activity;
        this.f3323b = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.f3324c.m6125c(this.f3322a, this.f3323b);
        } else {
            this.f3324c.m6127d(this.f3322a, this.f3323b);
        }
    }
}
