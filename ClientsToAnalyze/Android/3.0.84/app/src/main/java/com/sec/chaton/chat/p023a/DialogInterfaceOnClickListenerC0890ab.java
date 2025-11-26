package com.sec.chaton.chat.p023a;

import android.content.DialogInterface;

/* compiled from: SystemBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ab */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0890ab implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0889aa f3816a;

    DialogInterfaceOnClickListenerC0890ab(ViewOnClickListenerC0889aa viewOnClickListenerC0889aa) {
        this.f3816a = viewOnClickListenerC0889aa;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
