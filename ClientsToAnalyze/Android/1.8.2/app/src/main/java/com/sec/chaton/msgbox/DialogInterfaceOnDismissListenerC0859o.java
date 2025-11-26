package com.sec.chaton.msgbox;

import android.content.DialogInterface;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.o */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC0859o implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f3183a;

    DialogInterfaceOnDismissListenerC0859o(MsgboxFragment msgboxFragment) {
        this.f3183a = msgboxFragment;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f3183a.f3113g.setChoiceMode(0);
        this.f3183a.f3112f.setVisibility(8);
        this.f3183a.f3113g.clearChoices();
    }
}
