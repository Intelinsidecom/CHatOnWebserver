package com.sec.chaton.settings;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.p */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3678p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AccountFragment f13278a;

    DialogInterfaceOnClickListenerC3678p(AccountFragment accountFragment) {
        this.f13278a = accountFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f13278a.f12490q.m9431f();
        ((Activity) this.f13278a.f12487n).finish();
    }
}
