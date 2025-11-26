package com.sec.common.p063a;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.i */
/* loaded from: classes.dex */
class C3279i implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ Dialog f11878a;

    /* renamed from: b */
    final /* synthetic */ DialogC3275e f11879b;

    C3279i(DialogC3275e dialogC3275e, Dialog dialog) {
        this.f11879b = dialogC3275e;
        this.f11878a = dialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f11879b.f11865u.onClick(this.f11878a, i);
    }
}
