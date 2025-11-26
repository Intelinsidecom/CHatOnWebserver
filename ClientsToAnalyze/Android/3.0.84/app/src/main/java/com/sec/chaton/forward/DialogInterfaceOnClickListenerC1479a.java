package com.sec.chaton.forward;

import android.content.DialogInterface;

/* compiled from: ChatForwardFragment.java */
/* renamed from: com.sec.chaton.forward.a */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1479a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatForwardFragment f5486a;

    DialogInterfaceOnClickListenerC1479a(ChatForwardFragment chatForwardFragment) {
        this.f5486a = chatForwardFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f5486a.f5466d.m3440e();
                break;
            case 1:
                this.f5486a.f5466d.m3441f();
                break;
        }
    }
}
