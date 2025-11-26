package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.control.ContactControl;

/* renamed from: com.sec.chaton.buddy.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0082af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0132y f616a;

    DialogInterfaceOnClickListenerC0082af(HandlerC0132y handlerC0132y) {
        this.f616a = handlerC0132y;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f616a.f718a.f561H.show();
        new ContactControl(this.f616a.f718a.f578c).m1996b(this.f616a.f718a.f586k);
    }
}
