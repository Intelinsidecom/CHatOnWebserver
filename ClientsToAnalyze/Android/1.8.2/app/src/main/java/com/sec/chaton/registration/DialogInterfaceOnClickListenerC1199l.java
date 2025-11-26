package com.sec.chaton.registration;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.l */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1199l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f4414a;

    /* renamed from: b */
    final /* synthetic */ Activity f4415b;

    DialogInterfaceOnClickListenerC1199l(boolean z, Activity activity) {
        this.f4414a = z;
        this.f4415b = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        if (this.f4414a) {
            this.f4415b.finish();
        }
    }
}
