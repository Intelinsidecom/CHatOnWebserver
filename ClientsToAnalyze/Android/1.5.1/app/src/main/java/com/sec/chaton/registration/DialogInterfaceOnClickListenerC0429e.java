package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.registration.ActivityRegist;

/* renamed from: com.sec.chaton.registration.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0429e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.PhoneNumberAuthFragment f2942a;

    DialogInterfaceOnClickListenerC0429e(ActivityRegist.PhoneNumberAuthFragment phoneNumberAuthFragment) {
        this.f2942a = phoneNumberAuthFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
