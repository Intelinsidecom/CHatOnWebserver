package com.sec.chaton;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: UpgradeDialog.java */
/* renamed from: com.sec.chaton.ax */
/* loaded from: classes.dex */
class ViewOnClickListenerC0233ax implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeDialog f765a;

    ViewOnClickListenerC0233ax(UpgradeDialog upgradeDialog) {
        this.f765a = upgradeDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f765a.finish();
        GlobalApplication.m3258a(this.f765a);
    }
}
