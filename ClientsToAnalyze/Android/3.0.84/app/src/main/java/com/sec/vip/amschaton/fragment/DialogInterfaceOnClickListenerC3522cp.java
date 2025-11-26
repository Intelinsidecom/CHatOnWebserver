package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3522cp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12920a;

    DialogInterfaceOnClickListenerC3522cp(AMSStampSelectionFragment aMSStampSelectionFragment) {
        this.f12920a = aMSStampSelectionFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i <= 2) {
            switch (i) {
                case 0:
                    this.f12920a.m12600b(1003);
                    break;
                case 1:
                    this.f12920a.m12599b();
                    break;
            }
        }
    }
}
