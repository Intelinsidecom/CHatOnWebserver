package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.registration.ActivityNonSelfSMS;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.bg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0962bg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f3354a;

    DialogInterfaceOnClickListenerC0962bg(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment) {
        this.f3354a = nonSelfSMSFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
