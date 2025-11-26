package com.sec.common.p063a;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.k */
/* loaded from: classes.dex */
class C3281k implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ListView f11882a;

    /* renamed from: b */
    final /* synthetic */ Dialog f11883b;

    /* renamed from: c */
    final /* synthetic */ DialogC3275e f11884c;

    C3281k(DialogC3275e dialogC3275e, ListView listView, Dialog dialog) {
        this.f11884c = dialogC3275e;
        this.f11882a = listView;
        this.f11883b = dialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f11884c.f11859o != null) {
            this.f11884c.f11859o[i] = this.f11882a.isItemChecked(i);
        }
        this.f11884c.f11867w.onClick(this.f11883b, i, this.f11882a.isItemChecked(i));
    }
}
