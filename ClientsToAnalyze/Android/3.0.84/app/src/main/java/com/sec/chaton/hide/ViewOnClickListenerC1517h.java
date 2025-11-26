package com.sec.chaton.hide;

import android.view.View;

/* compiled from: HideImpl.java */
/* renamed from: com.sec.chaton.hide.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC1517h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1516g f5595a;

    ViewOnClickListenerC1517h(C1516g c1516g) {
        this.f5595a = c1516g;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5595a.f5589o.getFragmentManager().popBackStack();
    }
}
