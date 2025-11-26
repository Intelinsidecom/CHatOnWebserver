package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ay */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1917ay implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7055a;

    DialogInterfaceOnDismissListenerC1917ay(AMSPlayerActivity aMSPlayerActivity) {
        this.f7055a = aMSPlayerActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) throws IllegalStateException, Resources.NotFoundException {
        this.f7055a.m6772v();
        this.f7055a.f6688l.m6508b();
        this.f7055a.m6741h(false);
        this.f7055a.m6765s();
    }
}
