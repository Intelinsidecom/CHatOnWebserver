package com.sec.chaton.p030f;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: DialogMenu.java */
/* renamed from: com.sec.chaton.f.b */
/* loaded from: classes.dex */
class C1473b implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC1472a f5453a;

    C1473b(DialogC1472a dialogC1472a) {
        this.f5453a = dialogC1472a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f5453a.f5451b.mo4983a(((C1478g) this.f5453a.f5452c.get(i)).f5462c);
        this.f5453a.dismiss();
    }
}
