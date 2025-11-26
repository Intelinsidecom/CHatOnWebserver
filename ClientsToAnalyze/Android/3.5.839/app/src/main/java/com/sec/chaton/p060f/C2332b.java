package com.sec.chaton.p060f;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: DialogMenu.java */
/* renamed from: com.sec.chaton.f.b */
/* loaded from: classes.dex */
class C2332b implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2331a f8287a;

    C2332b(DialogC2331a dialogC2331a) {
        this.f8287a = dialogC2331a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f8287a.f8285b.mo8239a(((C2337g) this.f8287a.f8286c.get(i)).f8297c);
        this.f8287a.dismiss();
    }
}
