package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.SmsMessager;

/* renamed from: com.sec.chaton.registration.c */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0427c implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.PhoneNumberAuthFragment f2938a;

    DialogInterfaceOnCancelListenerC0427c(ActivityRegist.PhoneNumberAuthFragment phoneNumberAuthFragment) {
        this.f2938a = phoneNumberAuthFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        SmsMessager.m3660a(this.f2938a.getActivity());
        SmsMessager.m3661b(this.f2938a.getActivity());
        ChatONLogWriter.m3508c("Self SMS Canceled.", getClass().getName());
    }
}
