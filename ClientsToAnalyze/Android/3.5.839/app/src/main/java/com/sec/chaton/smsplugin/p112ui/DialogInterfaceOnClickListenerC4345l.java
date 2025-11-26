package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: ClassZeroActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.l */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4345l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ClassZeroActivity f15782a;

    DialogInterfaceOnClickListenerC4345l(ClassZeroActivity classZeroActivity) {
        this.f15782a = classZeroActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f15782a.f14749d = true;
        this.f15782a.m15741a();
        dialogInterface.dismiss();
        this.f15782a.finish();
    }
}
