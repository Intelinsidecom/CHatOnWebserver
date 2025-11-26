package com.sec.chaton.p031h;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: DialogMenu.java */
/* renamed from: com.sec.chaton.h.d */
/* loaded from: classes.dex */
class C0719d implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC0716a f2441a;

    C0719d(DialogC0716a dialogC0716a) {
        this.f2441a = dialogC0716a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f2441a.f2431b.mo2700a(this.f2441a.f2432c, ((C0717b) this.f2441a.f2433d.get(i)).f2436c);
        this.f2441a.dismiss();
    }
}
