package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C4859bx;

/* compiled from: AbstractUpgradeDialog.java */
/* renamed from: com.sec.chaton.registration.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC3158b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11910a;

    /* renamed from: b */
    final /* synthetic */ AbstractUpgradeDialog f11911b;

    ViewOnClickListenerC3158b(AbstractUpgradeDialog abstractUpgradeDialog, int i) {
        this.f11911b = abstractUpgradeDialog;
        this.f11910a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4859bx.m18378a(this.f11910a);
        if (this.f11910a == 1 || this.f11910a == 2) {
            this.f11911b.finish();
        }
    }
}
