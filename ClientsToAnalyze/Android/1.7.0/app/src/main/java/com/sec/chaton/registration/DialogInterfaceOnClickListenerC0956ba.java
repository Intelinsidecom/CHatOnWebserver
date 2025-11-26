package com.sec.chaton.registration;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.ba */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC0956ba implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f3347a;

    /* renamed from: b */
    final /* synthetic */ Activity f3348b;

    DialogInterfaceOnClickListenerC0956ba(boolean z, Activity activity) {
        this.f3347a = z;
        this.f3348b = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f3347a) {
            this.f3348b.finish();
        }
    }
}
