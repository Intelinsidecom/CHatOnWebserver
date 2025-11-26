package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C3214cb;

/* compiled from: AbstractUpgradeDialog.java */
/* renamed from: com.sec.chaton.registration.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC2203d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f8495a;

    /* renamed from: b */
    final /* synthetic */ AbstractUpgradeDialog f8496b;

    ViewOnClickListenerC2203d(AbstractUpgradeDialog abstractUpgradeDialog, int i) {
        this.f8496b = abstractUpgradeDialog;
        this.f8495a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f8496b.f8087l) {
            if (this.f8496b.f8085j) {
                C3214cb.m11259b(this.f8495a);
                return;
            } else {
                C3214cb.m11270f(this.f8495a);
                return;
            }
        }
        C3214cb.m11267d(this.f8495a);
    }
}
