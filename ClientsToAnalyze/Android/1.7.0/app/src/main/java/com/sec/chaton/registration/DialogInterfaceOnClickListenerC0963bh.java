package com.sec.chaton.registration;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.bh */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC0963bh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f3355a;

    /* renamed from: b */
    final /* synthetic */ Activity f3356b;

    DialogInterfaceOnClickListenerC0963bh(boolean z, Activity activity) {
        this.f3355a = z;
        this.f3356b = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f3355a) {
            this.f3356b.finish();
        }
    }
}
