package com.sec.chaton;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;

/* renamed from: com.sec.chaton.m */
/* loaded from: classes.dex */
class ViewOnClickListenerC0245m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeDialog f1921a;

    ViewOnClickListenerC0245m(UpgradeDialog upgradeDialog) {
        this.f1921a = upgradeDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1921a.finish();
        GlobalApplication.m2384a(this.f1921a);
    }
}
