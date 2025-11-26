package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C3214cb;

/* compiled from: AbstractUpgradeDialog.java */
/* renamed from: com.sec.chaton.registration.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC2122a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f8387a;

    /* renamed from: b */
    final /* synthetic */ AbstractUpgradeDialog f8388b;

    ViewOnClickListenerC2122a(AbstractUpgradeDialog abstractUpgradeDialog, int i) {
        this.f8388b = abstractUpgradeDialog;
        this.f8387a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f8388b.f8087l) {
            if (this.f8388b.f8085j) {
                C3214cb.m11259b(this.f8387a);
                return;
            } else {
                C3214cb.m11270f(this.f8387a);
                return;
            }
        }
        C3214cb.m11267d(this.f8387a);
    }
}
