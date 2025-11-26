package com.sec.chaton.forward;

import android.content.DialogInterface;

/* compiled from: ChatForwardFragment.java */
/* renamed from: com.sec.chaton.forward.a */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2338a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatForwardFragment f8321a;

    DialogInterfaceOnClickListenerC2338a(ChatForwardFragment chatForwardFragment) {
        this.f8321a = chatForwardFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f8321a.f8301d.m6601d();
                break;
            case 1:
                this.f8321a.f8301d.m6602e();
                break;
        }
    }
}
