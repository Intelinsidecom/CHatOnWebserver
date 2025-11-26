package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C3214cb;

/* compiled from: AbstractUpgradeDialog.java */
/* renamed from: com.sec.chaton.registration.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC2149b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f8424a;

    /* renamed from: b */
    final /* synthetic */ AbstractUpgradeDialog f8425b;

    ViewOnClickListenerC2149b(AbstractUpgradeDialog abstractUpgradeDialog, int i) {
        this.f8425b = abstractUpgradeDialog;
        this.f8424a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3214cb.m11259b(this.f8424a);
    }
}
