package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.am */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1417am implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5048a;

    DialogInterfaceOnDismissListenerC1417am(AMSPlayerActivity aMSPlayerActivity) {
        this.f5048a = aMSPlayerActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) throws Resources.NotFoundException {
        this.f5048a.m5207s();
        this.f5048a.f4701a.m5636b();
        this.f5048a.m5179g(false);
        this.f5048a.m5201p();
    }
}
