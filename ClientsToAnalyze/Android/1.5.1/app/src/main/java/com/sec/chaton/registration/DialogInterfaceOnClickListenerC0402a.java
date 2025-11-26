package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.SmsMessager;

/* renamed from: com.sec.chaton.registration.a */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0402a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.PhoneNumberAuthFragment f2910a;

    DialogInterfaceOnClickListenerC0402a(ActivityRegist.PhoneNumberAuthFragment phoneNumberAuthFragment) {
        this.f2910a = phoneNumberAuthFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SmsMessager.m3660a(this.f2910a.getActivity());
        SmsMessager.m3661b(this.f2910a.getActivity());
        ChatONLogWriter.m3508c("Self SMS Cancelled.", getClass().getName());
        dialogInterface.dismiss();
    }
}
