package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.registration.ActivityNonSelfSMS;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.m */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1200m implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f4416a;

    DialogInterfaceOnClickListenerC1200m(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment) {
        this.f4416a = nonSelfSMSFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }
}
