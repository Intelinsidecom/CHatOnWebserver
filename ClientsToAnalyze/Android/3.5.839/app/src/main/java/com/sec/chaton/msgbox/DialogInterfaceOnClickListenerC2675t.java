package com.sec.chaton.msgbox;

import android.content.DialogInterface;
import android.widget.CheckBox;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.t */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2675t implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f9586a;

    /* renamed from: b */
    final /* synthetic */ CheckBox f9587b;

    /* renamed from: c */
    final /* synthetic */ Runnable f9588c;

    /* renamed from: d */
    final /* synthetic */ Runnable f9589d;

    /* renamed from: e */
    final /* synthetic */ C2660e f9590e;

    DialogInterfaceOnClickListenerC2675t(C2660e c2660e, boolean z, CheckBox checkBox, Runnable runnable, Runnable runnable2) {
        this.f9590e = c2660e;
        this.f9586a = z;
        this.f9587b = checkBox;
        this.f9588c = runnable;
        this.f9589d = runnable2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9586a && this.f9587b.isChecked()) {
            this.f9588c.run();
        } else {
            this.f9589d.run();
        }
    }
}
