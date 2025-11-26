package com.sec.chaton.localbackup.chatview;

import android.content.DialogInterface;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.l */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1631l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatViewFragment f6076a;

    DialogInterfaceOnClickListenerC1631l(ChatViewFragment chatViewFragment) {
        this.f6076a = chatViewFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
