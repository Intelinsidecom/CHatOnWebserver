package com.sec.chaton.registration;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.dj */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC2213dj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f8505a;

    /* renamed from: b */
    final /* synthetic */ Activity f8506b;

    DialogInterfaceOnClickListenerC2213dj(boolean z, Activity activity) {
        this.f8505a = z;
        this.f8506b = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f8505a) {
            this.f8506b.finish();
        }
    }
}
