package com.sec.chaton.smsplugin.p103c;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: MmsDialogMenu.java */
/* renamed from: com.sec.chaton.smsplugin.c.b */
/* loaded from: classes.dex */
class C3807b implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC3806a f13669a;

    C3807b(DialogC3806a dialogC3806a) {
        this.f13669a = dialogC3806a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((InterfaceC3810e) this.f13669a.f13668d).mo14481a(((C3809d) this.f13669a.f13667c.get(i)).f13675c, this.f13669a.f13665a);
        this.f13669a.dismiss();
    }
}
