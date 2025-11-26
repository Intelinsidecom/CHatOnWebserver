package com.sec.chaton.ignore;

import android.view.View;
import com.sec.chaton.p015d.C0636h;

/* compiled from: IgnoreBuddyAdapter.java */
/* renamed from: com.sec.chaton.ignore.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0823b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0822a f3035a;

    ViewOnClickListenerC0823b(C0822a c0822a) {
        this.f3035a = c0822a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.f3035a.f3032i = iIntValue;
        this.f3035a.f3028e = ((C0829h) this.f3035a.f3024a.get(iIntValue)).f3043a;
        this.f3035a.f3033j.add(this.f3035a.f3028e);
        this.f3035a.f3027d = new C0636h(this.f3035a.f3025b);
        this.f3035a.f3027d.m2891a(this.f3035a.f3033j);
        this.f3035a.f3030g.show();
    }
}
