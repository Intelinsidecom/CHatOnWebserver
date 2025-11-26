package com.sec.chaton.smsplugin.spam;

import android.content.DialogInterface;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.az */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3995az implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberList f14436a;

    DialogInterfaceOnClickListenerC3995az(SetupSpamNumberList setupSpamNumberList) {
        this.f14436a = setupSpamNumberList;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f14436a.m15391k();
                break;
            case 1:
                this.f14436a.m15402f();
                break;
        }
    }
}
