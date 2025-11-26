package com.sec.chaton.localbackup;

import android.content.DialogInterface;

/* compiled from: SecretKeyView.java */
/* renamed from: com.sec.chaton.localbackup.w */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1664w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SecretKeyView f6149a;

    DialogInterfaceOnClickListenerC1664w(SecretKeyView secretKeyView) {
        this.f6149a = secretKeyView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f6149a.f5984u != null) {
            this.f6149a.f5984u.mo6807a(false);
        }
    }
}
