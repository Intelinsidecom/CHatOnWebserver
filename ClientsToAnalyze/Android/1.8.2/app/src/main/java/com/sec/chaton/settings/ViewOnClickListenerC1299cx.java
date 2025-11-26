package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.buddy.p010a.C0257c;

/* compiled from: RelationHideAdapter.java */
/* renamed from: com.sec.chaton.settings.cx */
/* loaded from: classes.dex */
class ViewOnClickListenerC1299cx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f4860a;

    /* renamed from: b */
    final /* synthetic */ C1298cw f4861b;

    ViewOnClickListenerC1299cx(C1298cw c1298cw, int i) {
        this.f4861b = c1298cw;
        this.f4860a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4861b.f4857e = ((C0257c) this.f4861b.f4853a.get(this.f4860a)).m2318a();
        this.f4861b.f4856d = ((C0257c) this.f4861b.f4853a.get(this.f4860a)).m2324b();
    }
}
