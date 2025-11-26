package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: FragmentSkinChange3.java */
/* renamed from: com.sec.chaton.settings.fd */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3621fd implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange3 f13155a;

    DialogInterfaceOnCancelListenerC3621fd(FragmentSkinChange3 fragmentSkinChange3) {
        this.f13155a = fragmentSkinChange3;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.f13155a.f12739D = false;
    }
}
