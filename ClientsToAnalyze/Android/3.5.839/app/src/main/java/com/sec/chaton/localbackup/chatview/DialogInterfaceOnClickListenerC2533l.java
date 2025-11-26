package com.sec.chaton.localbackup.chatview;

import android.content.DialogInterface;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.l */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2533l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatViewFragment f9120a;

    DialogInterfaceOnClickListenerC2533l(ChatViewFragment chatViewFragment) {
        this.f9120a = chatViewFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
