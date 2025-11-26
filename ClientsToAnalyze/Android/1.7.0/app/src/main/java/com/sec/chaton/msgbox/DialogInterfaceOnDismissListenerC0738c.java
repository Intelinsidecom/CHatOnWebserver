package com.sec.chaton.msgbox;

import android.content.DialogInterface;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.c */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC0738c implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2533a;

    DialogInterfaceOnDismissListenerC0738c(MsgboxFragment msgboxFragment) {
        this.f2533a = msgboxFragment;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f2533a.f2500f.setChoiceMode(0);
        this.f2533a.f2499e.setVisibility(8);
        this.f2533a.f2500f.clearChoices();
    }
}
