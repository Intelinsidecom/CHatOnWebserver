package com.sec.chaton;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: UpgradeDialog.java */
/* renamed from: com.sec.chaton.ah */
/* loaded from: classes.dex */
class ViewOnClickListenerC0245ah implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeDialog f592a;

    ViewOnClickListenerC0245ah(UpgradeDialog upgradeDialog) {
        this.f592a = upgradeDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f592a.finish();
        GlobalApplication.m3102a(this.f592a);
    }
}
