package com.sec.chaton.localbackup;

import android.content.DialogInterface;

/* compiled from: SecretKeyView.java */
/* renamed from: com.sec.chaton.localbackup.y */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2566y implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SecretKeyView f9194a;

    DialogInterfaceOnClickListenerC2566y(SecretKeyView secretKeyView) {
        this.f9194a = secretKeyView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9194a.f9026u != null) {
            this.f9194a.f9026u.mo10835b(false);
        }
    }
}
