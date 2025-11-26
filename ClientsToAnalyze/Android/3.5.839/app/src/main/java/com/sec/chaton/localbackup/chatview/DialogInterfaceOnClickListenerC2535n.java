package com.sec.chaton.localbackup.chatview;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.n */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2535n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f9123a;

    /* renamed from: b */
    final /* synthetic */ Intent f9124b;

    /* renamed from: c */
    final /* synthetic */ ChatViewFragment f9125c;

    DialogInterfaceOnClickListenerC2535n(ChatViewFragment chatViewFragment, boolean z, Intent intent) {
        this.f9125c = chatViewFragment;
        this.f9123a = z;
        this.f9124b = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9123a) {
            this.f9125c.startActivity(this.f9124b);
        }
    }
}
