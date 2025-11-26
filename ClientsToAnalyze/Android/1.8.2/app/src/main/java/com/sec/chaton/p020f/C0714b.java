package com.sec.chaton.p020f;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: DialogMenu.java */
/* renamed from: com.sec.chaton.f.b */
/* loaded from: classes.dex */
class C0714b implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC0713a f2674a;

    C0714b(DialogC0713a dialogC0713a) {
        this.f2674a = dialogC0713a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f2674a.f2671b.mo2602a(this.f2674a.f2672c, ((C0719g) this.f2674a.f2673d.get(i)).f2685c);
        this.f2674a.dismiss();
    }
}
