package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: FragmentSkinChange3.java */
/* renamed from: com.sec.chaton.settings.eg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2670eg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange3 f9937a;

    DialogInterfaceOnClickListenerC2670eg(FragmentSkinChange3 fragmentSkinChange3) {
        this.f9937a = fragmentSkinChange3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.f9937a.f9178D = false;
    }
}
