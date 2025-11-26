package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSViewerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.dq */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC3550dq implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ AMSViewerFragment f12980a;

    DialogInterfaceOnDismissListenerC3550dq(AMSViewerFragment aMSViewerFragment) {
        this.f12980a = aMSViewerFragment;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) throws IllegalStateException {
        this.f12980a.m12688j();
        this.f12980a.f12795b.m12330b();
        this.f12980a.m12700b(false);
        this.f12980a.m12695a();
    }
}
