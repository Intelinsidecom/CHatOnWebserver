package com.sec.chaton;

import android.view.View;

/* renamed from: com.sec.chaton.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC0338n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeDialog f2427a;

    ViewOnClickListenerC0338n(UpgradeDialog upgradeDialog) {
        this.f2427a = upgradeDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2427a.finish();
    }
}
