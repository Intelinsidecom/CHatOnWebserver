package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.ch */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3383ch implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f12342a;

    /* renamed from: b */
    final /* synthetic */ C3381cf f12343b;

    DialogInterfaceOnClickListenerC3383ch(C3381cf c3381cf, boolean z) {
        this.f12343b = c3381cf;
        this.f12342a = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!this.f12342a) {
            if (this.f12343b.f12339a.f12320n.canGoBack()) {
                this.f12343b.f12339a.f12320n.goBack();
                return;
            }
            return;
        }
        this.f12343b.f12339a.dismiss();
    }
}
