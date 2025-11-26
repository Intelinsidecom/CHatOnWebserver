package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.cc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1949cc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f7093a;

    DialogInterfaceOnClickListenerC1949cc(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f7093a = aMSStampSelectionActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f7093a.m6813b(1004);
                break;
            case 1:
                this.f7093a.m6813b(1003);
                break;
        }
    }
}
