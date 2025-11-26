package com.sec.chaton.msgbox;

import android.content.DialogInterface;
import android.widget.CheckBox;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.n */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC2669n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f9577a;

    /* renamed from: b */
    final /* synthetic */ boolean f9578b;

    /* renamed from: c */
    final /* synthetic */ Runnable f9579c;

    /* renamed from: d */
    final /* synthetic */ Runnable f9580d;

    DialogInterfaceOnClickListenerC2669n(CheckBox checkBox, boolean z, Runnable runnable, Runnable runnable2) {
        this.f9577a = checkBox;
        this.f9578b = z;
        this.f9579c = runnable;
        this.f9580d = runnable2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if ((this.f9577a != null && this.f9577a.isChecked()) || !this.f9578b) {
            this.f9579c.run();
        } else {
            this.f9580d.run();
        }
    }
}
