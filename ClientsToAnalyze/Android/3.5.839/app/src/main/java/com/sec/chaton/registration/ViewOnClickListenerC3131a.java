package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C4859bx;

/* compiled from: AbstractUpgradeDialog.java */
/* renamed from: com.sec.chaton.registration.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC3131a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11861a;

    /* renamed from: b */
    final /* synthetic */ AbstractUpgradeDialog f11862b;

    ViewOnClickListenerC3131a(AbstractUpgradeDialog abstractUpgradeDialog, int i) {
        this.f11862b = abstractUpgradeDialog;
        this.f11861a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f11862b.f11541y) {
            if (this.f11862b.f11539w) {
                C4859bx.m18378a(this.f11861a);
            } else {
                C4859bx.m18403e(this.f11861a);
            }
        } else {
            C4859bx.m18395c(this.f11861a);
        }
        if (this.f11861a == 1 || this.f11861a == 2) {
            this.f11862b.finish();
        }
    }
}
