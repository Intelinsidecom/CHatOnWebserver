package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.registration.ActivityNonSelfSMS;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.bb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0957bb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f3349a;

    DialogInterfaceOnClickListenerC0957bb(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment) {
        this.f3349a = nonSelfSMSFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
