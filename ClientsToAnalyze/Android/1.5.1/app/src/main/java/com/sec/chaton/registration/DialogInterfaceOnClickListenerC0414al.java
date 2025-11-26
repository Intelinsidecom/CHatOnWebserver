package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.registration.ActivityRegist;

/* renamed from: com.sec.chaton.registration.al */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0414al implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0426b f2925a;

    DialogInterfaceOnClickListenerC0414al(HandlerC0426b handlerC0426b) {
        this.f2925a = handlerC0426b;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ActivityRegist.PhoneNumberAuthFragment.f2848b.dismiss();
    }
}
