package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2352bn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2351bm f8807a;

    DialogInterfaceOnClickListenerC2352bn(C2351bm c2351bm) {
        this.f8807a = c2351bm;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8807a.f8805a.f8788n.canGoBack()) {
            this.f8807a.f8805a.f8788n.goBack();
        }
    }
}
