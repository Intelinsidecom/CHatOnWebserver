package com.sec.chaton.localbackup.chatview;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.n */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1633n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f6079a;

    /* renamed from: b */
    final /* synthetic */ Intent f6080b;

    /* renamed from: c */
    final /* synthetic */ ChatViewFragment f6081c;

    DialogInterfaceOnClickListenerC1633n(ChatViewFragment chatViewFragment, boolean z, Intent intent) {
        this.f6081c = chatViewFragment;
        this.f6079a = z;
        this.f6080b = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f6079a) {
            this.f6081c.startActivity(this.f6080b);
        }
    }
}
