package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.au */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3152au implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11904a;

    DialogInterfaceOnClickListenerC3152au(C3134ac c3134ac) {
        this.f11904a = c3134ac;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f11904a.f11880p != null && this.f11904a.f11880p.isShowing()) {
            this.f11904a.f11880p.dismiss();
        }
    }
}
