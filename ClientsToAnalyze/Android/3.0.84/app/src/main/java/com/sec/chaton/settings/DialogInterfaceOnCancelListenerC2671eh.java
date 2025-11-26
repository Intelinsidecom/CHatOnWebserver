package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: FragmentSkinChange3.java */
/* renamed from: com.sec.chaton.settings.eh */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2671eh implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange3 f9938a;

    DialogInterfaceOnCancelListenerC2671eh(FragmentSkinChange3 fragmentSkinChange3) {
        this.f9938a = fragmentSkinChange3;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.f9938a.f9178D = false;
    }
}
