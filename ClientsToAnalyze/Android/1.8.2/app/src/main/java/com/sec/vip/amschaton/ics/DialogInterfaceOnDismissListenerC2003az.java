package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.az */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC2003az implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7285a;

    DialogInterfaceOnDismissListenerC2003az(AMSPlayerActivity aMSPlayerActivity) {
        this.f7285a = aMSPlayerActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) throws IllegalStateException, Resources.NotFoundException {
        this.f7285a.m7092u();
        this.f7285a.f6688l.m6508b();
        this.f7285a.m7055e(false);
        this.f7285a.m7085q();
    }
}
