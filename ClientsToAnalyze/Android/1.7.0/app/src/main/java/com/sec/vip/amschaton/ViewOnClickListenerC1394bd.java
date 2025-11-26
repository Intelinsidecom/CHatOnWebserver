package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.bd */
/* loaded from: classes.dex */
class ViewOnClickListenerC1394bd implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1369af f4887a;

    ViewOnClickListenerC1394bd(C1369af c1369af) {
        this.f4887a = c1369af;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4887a.f4810p = new DialogC1363a(this.f4887a.m5646a());
        this.f4887a.f4810p.m4862a(this.f4887a.f4804j);
        this.f4887a.f4810p.m4863a(new C1376am(this));
        this.f4887a.f4810p.show();
    }
}
