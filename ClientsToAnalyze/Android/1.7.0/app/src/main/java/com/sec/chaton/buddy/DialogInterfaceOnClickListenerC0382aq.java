package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.aq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0382aq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0416bx f1351a;

    DialogInterfaceOnClickListenerC0382aq(HandlerC0416bx handlerC0416bx) {
        this.f1351a = handlerC0416bx;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f1351a.f1391a.f1058A != null) {
            this.f1351a.f1391a.getActivity().finish();
        }
    }
}
