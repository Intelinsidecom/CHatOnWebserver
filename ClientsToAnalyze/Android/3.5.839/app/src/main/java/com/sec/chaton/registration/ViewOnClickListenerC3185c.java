package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C4859bx;

/* compiled from: AbstractUpgradeDialog.java */
/* renamed from: com.sec.chaton.registration.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC3185c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11948a;

    /* renamed from: b */
    final /* synthetic */ AbstractUpgradeDialog f11949b;

    ViewOnClickListenerC3185c(AbstractUpgradeDialog abstractUpgradeDialog, int i) {
        this.f11949b = abstractUpgradeDialog;
        this.f11948a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4859bx.m18395c(this.f11948a);
        if (this.f11948a == 1 || this.f11948a == 2) {
            this.f11949b.finish();
        }
    }
}
