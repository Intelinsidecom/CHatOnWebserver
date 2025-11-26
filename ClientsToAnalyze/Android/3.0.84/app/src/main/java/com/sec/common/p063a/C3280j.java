package com.sec.common.p063a;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.j */
/* loaded from: classes.dex */
class C3280j implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ Dialog f11880a;

    /* renamed from: b */
    final /* synthetic */ DialogC3275e f11881b;

    C3280j(DialogC3275e dialogC3275e, Dialog dialog) {
        this.f11881b = dialogC3275e;
        this.f11880a = dialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f11881b.f11865u.onClick(this.f11880a, i);
        if (!this.f11881b.f11856l) {
            this.f11880a.dismiss();
        }
    }
}
