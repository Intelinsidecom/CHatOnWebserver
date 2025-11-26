package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3520cn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12918a;

    DialogInterfaceOnClickListenerC3520cn(AMSStampSelectionFragment aMSStampSelectionFragment) {
        this.f12918a = aMSStampSelectionFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f12918a.m12600b(1004);
                break;
            case 1:
                this.f12918a.m12600b(1003);
                break;
            case 2:
                this.f12918a.m12599b();
                break;
        }
    }
}
