package com.sec.chaton.registration;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.dk */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC2214dk implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f8507a;

    /* renamed from: b */
    final /* synthetic */ Activity f8508b;

    DialogInterfaceOnClickListenerC2214dk(boolean z, Activity activity) {
        this.f8507a = z;
        this.f8508b = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f8507a) {
            this.f8508b.finish();
        }
    }
}
