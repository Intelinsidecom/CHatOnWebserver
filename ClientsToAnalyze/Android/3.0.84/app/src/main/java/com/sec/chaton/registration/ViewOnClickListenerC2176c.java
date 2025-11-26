package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C3214cb;

/* compiled from: AbstractUpgradeDialog.java */
/* renamed from: com.sec.chaton.registration.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC2176c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f8461a;

    /* renamed from: b */
    final /* synthetic */ AbstractUpgradeDialog f8462b;

    ViewOnClickListenerC2176c(AbstractUpgradeDialog abstractUpgradeDialog, int i) {
        this.f8462b = abstractUpgradeDialog;
        this.f8461a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3214cb.m11267d(this.f8461a);
    }
}
