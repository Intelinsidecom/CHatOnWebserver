package com.sec.chaton;

import android.content.DialogInterface;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0466bg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1534a;

    DialogInterfaceOnClickListenerC0466bg(TabActivity tabActivity) {
        this.f1534a = tabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
