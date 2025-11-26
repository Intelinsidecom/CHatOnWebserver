package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: FragmentSkinChange3.java */
/* renamed from: com.sec.chaton.settings.fc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3620fc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange3 f13154a;

    DialogInterfaceOnClickListenerC3620fc(FragmentSkinChange3 fragmentSkinChange3) {
        this.f13154a = fragmentSkinChange3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.f13154a.f12739D = false;
    }
}
