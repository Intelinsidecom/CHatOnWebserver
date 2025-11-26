package com.sec.chaton.smsplugin.spam;

import android.content.DialogInterface;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.y */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4047y implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamKeywordList f14561a;

    DialogInterfaceOnClickListenerC4047y(SetupSpamKeywordList setupSpamKeywordList) {
        this.f14561a = setupSpamKeywordList;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f14561a.m15334d();
                break;
            case 1:
                this.f14561a.m15347a();
                break;
        }
    }
}
