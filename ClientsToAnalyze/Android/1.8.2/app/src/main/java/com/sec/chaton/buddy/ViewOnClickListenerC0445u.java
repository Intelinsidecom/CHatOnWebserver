package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.p015d.C0633e;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC0445u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0442r f1694a;

    ViewOnClickListenerC0445u(C0442r c0442r) {
        this.f1694a = c0442r;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0257c c0257c = (C0257c) view.getTag();
        this.f1694a.f1690y = c0257c.m2324b();
        this.f1694a.f1689x = c0257c.m2318a();
        new C0633e(this.f1694a.f1668c).m2868b(this.f1694a.f1689x);
        this.f1694a.f1688w.show();
    }
}
