package com.sec.chaton.registration;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

/* compiled from: AbstractUpgradeDialog.java */
/* renamed from: com.sec.chaton.registration.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC2257f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f8552a;

    /* renamed from: b */
    final /* synthetic */ AbstractUpgradeDialog f8553b;

    ViewOnClickListenerC2257f(AbstractUpgradeDialog abstractUpgradeDialog, int i) {
        this.f8553b = abstractUpgradeDialog;
        this.f8552a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent("upgrade_cancel");
        intent.putExtra("which_service", this.f8552a);
        LocalBroadcastManager.getInstance(this.f8553b.getApplicationContext()).sendBroadcast(intent);
        this.f8553b.finish();
    }
}
