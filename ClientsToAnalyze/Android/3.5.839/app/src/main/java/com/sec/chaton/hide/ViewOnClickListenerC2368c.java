package com.sec.chaton.hide;

import android.view.View;
import com.sec.chaton.p055d.C2133n;

/* compiled from: HideBuddyAdapter.java */
/* renamed from: com.sec.chaton.hide.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC2368c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2366a f8443a;

    ViewOnClickListenerC2368c(C2366a c2366a) {
        this.f8443a = c2366a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.f8443a.f8436e = this.f8443a.f8432a.get(iIntValue).f3484a;
        this.f8443a.f8435d = new C2133n(this.f8443a.f8433b);
        this.f8443a.f8435d.m9562b(this.f8443a.f8436e);
        this.f8443a.f8438g.show();
    }
}
