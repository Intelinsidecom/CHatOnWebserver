package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSSendDialog.java */
/* renamed from: com.sec.vip.amschaton.ag */
/* loaded from: classes.dex */
class ViewOnClickListenerC3405ag implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3402ad f12476a;

    ViewOnClickListenerC3405ag(C3402ad c3402ad) {
        this.f12476a = c3402ad;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12476a.f12470e.sendAccessibilityEvent(1);
    }
}
