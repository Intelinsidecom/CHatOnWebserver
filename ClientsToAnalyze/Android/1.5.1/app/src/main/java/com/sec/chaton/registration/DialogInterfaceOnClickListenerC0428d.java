package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.registration.ActivityRegist;

/* renamed from: com.sec.chaton.registration.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0428d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2939a;

    /* renamed from: b */
    final /* synthetic */ String f2940b;

    /* renamed from: c */
    final /* synthetic */ ActivityRegist.PhoneNumberAuthFragment f2941c;

    DialogInterfaceOnClickListenerC0428d(ActivityRegist.PhoneNumberAuthFragment phoneNumberAuthFragment, String str, String str2) {
        this.f2941c = phoneNumberAuthFragment;
        this.f2939a = str;
        this.f2940b = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f2941c.f2852c.show();
            this.f2941c.f2853d.m2001a(this.f2939a, this.f2940b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
