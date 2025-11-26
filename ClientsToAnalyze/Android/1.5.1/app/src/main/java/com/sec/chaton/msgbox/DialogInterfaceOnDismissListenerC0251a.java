package com.sec.chaton.msgbox;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.msgbox.a */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC0251a implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f1988a;

    DialogInterfaceOnDismissListenerC0251a(MsgboxFragment msgboxFragment) {
        this.f1988a = msgboxFragment;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1988a.f1975n.setChoiceMode(0);
        this.f1988a.f1974m.setVisibility(8);
        this.f1988a.f1975n.clearChoices();
    }
}
