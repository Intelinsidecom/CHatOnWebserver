package com.sec.chaton.registration;

import android.content.Intent;
import android.support.v4.content.C0096i;
import android.view.View;

/* compiled from: AbstractUpgradeDialog.java */
/* renamed from: com.sec.chaton.registration.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC3266f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f12033a;

    /* renamed from: b */
    final /* synthetic */ AbstractUpgradeDialog f12034b;

    ViewOnClickListenerC3266f(AbstractUpgradeDialog abstractUpgradeDialog, int i) {
        this.f12034b = abstractUpgradeDialog;
        this.f12033a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent("upgrade_cancel");
        intent.putExtra("which_service", this.f12033a);
        C0096i.m358a(this.f12034b.getApplicationContext()).m363a(intent);
        this.f12034b.finish();
    }
}
