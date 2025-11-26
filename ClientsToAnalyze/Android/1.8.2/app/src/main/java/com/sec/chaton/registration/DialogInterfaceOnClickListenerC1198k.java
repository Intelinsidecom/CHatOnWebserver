package com.sec.chaton.registration;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.k */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1198k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f4412a;

    /* renamed from: b */
    final /* synthetic */ Activity f4413b;

    DialogInterfaceOnClickListenerC1198k(boolean z, Activity activity) {
        this.f4412a = z;
        this.f4413b = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        if (this.f4412a) {
            this.f4413b.finish();
        }
    }
}
