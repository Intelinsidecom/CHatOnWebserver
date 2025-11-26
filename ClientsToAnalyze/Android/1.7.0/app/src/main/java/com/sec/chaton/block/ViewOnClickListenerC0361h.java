package com.sec.chaton.block;

import android.view.View;
import com.sec.chaton.p013a.C0217p;

/* compiled from: BlockBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC0361h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0358e f1057a;

    ViewOnClickListenerC0361h(C0358e c0358e) {
        this.f1057a = c0358e;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.f1057a.f1047f = ((C0359f) this.f1057a.f1042a.get(iIntValue)).f1052a;
        this.f1057a.f1046e = ((C0359f) this.f1057a.f1042a.get(iIntValue)).f1053b;
        this.f1057a.f1045d = new C0217p(this.f1057a.f1043b);
        this.f1057a.f1045d.m797a(this.f1057a.f1047f);
        this.f1057a.f1049h.show();
    }
}
