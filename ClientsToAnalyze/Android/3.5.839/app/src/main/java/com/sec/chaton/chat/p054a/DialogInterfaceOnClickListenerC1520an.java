package com.sec.chaton.chat.p054a;

import android.content.DialogInterface;

/* compiled from: SystemBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.an */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1520an implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC1519am f5911a;

    DialogInterfaceOnClickListenerC1520an(ViewOnClickListenerC1519am viewOnClickListenerC1519am) {
        this.f5911a = viewOnClickListenerC1519am;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
