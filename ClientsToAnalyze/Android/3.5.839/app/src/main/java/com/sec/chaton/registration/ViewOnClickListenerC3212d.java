package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C4859bx;

/* compiled from: AbstractUpgradeDialog.java */
/* renamed from: com.sec.chaton.registration.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC3212d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11976a;

    /* renamed from: b */
    final /* synthetic */ AbstractUpgradeDialog f11977b;

    ViewOnClickListenerC3212d(AbstractUpgradeDialog abstractUpgradeDialog, int i) {
        this.f11977b = abstractUpgradeDialog;
        this.f11976a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f11977b.f11541y) {
            if (this.f11977b.f11539w) {
                C4859bx.m18378a(this.f11976a);
            } else {
                C4859bx.m18403e(this.f11976a);
            }
        } else {
            C4859bx.m18395c(this.f11976a);
        }
        if (this.f11976a == 1 || this.f11976a == 2) {
            this.f11977b.finish();
        }
    }
}
