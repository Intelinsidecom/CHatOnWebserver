package com.sec.chaton.registration;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.dk */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC3223dk implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f11988a;

    /* renamed from: b */
    final /* synthetic */ Activity f11989b;

    DialogInterfaceOnClickListenerC3223dk(boolean z, Activity activity) {
        this.f11988a = z;
        this.f11989b = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f11988a) {
            this.f11989b.finish();
        }
    }
}
