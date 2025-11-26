package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bj */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1506bj implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5329a;

    DialogInterfaceOnDismissListenerC1506bj(AMSPlayerActivity aMSPlayerActivity) {
        this.f5329a = aMSPlayerActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) throws Resources.NotFoundException {
        this.f5329a.m5533u();
        this.f5329a.f4701a.m5636b();
        this.f5329a.m5496e(false);
        this.f5329a.m5524p();
    }
}
