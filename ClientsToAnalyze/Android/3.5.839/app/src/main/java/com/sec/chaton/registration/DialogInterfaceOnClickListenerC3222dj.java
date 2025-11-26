package com.sec.chaton.registration;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.dj */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC3222dj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f11986a;

    /* renamed from: b */
    final /* synthetic */ Activity f11987b;

    DialogInterfaceOnClickListenerC3222dj(boolean z, Activity activity) {
        this.f11986a = z;
        this.f11987b = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f11986a) {
            this.f11987b.finish();
        }
    }
}
