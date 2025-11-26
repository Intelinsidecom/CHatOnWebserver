package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSSendDialog.java */
/* renamed from: com.sec.vip.amschaton.aj */
/* loaded from: classes.dex */
class ViewOnClickListenerC3408aj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3402ad f12479a;

    ViewOnClickListenerC3408aj(C3402ad c3402ad) {
        this.f12479a = c3402ad;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12479a.f12473h.onClick(view.getId(), this.f12479a.f12472g);
        this.f12479a.m12166d();
        this.f12479a.f12468c.dismiss();
    }
}
