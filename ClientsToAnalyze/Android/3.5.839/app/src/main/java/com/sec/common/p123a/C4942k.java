package com.sec.common.p123a;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.k */
/* loaded from: classes.dex */
class C4942k implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ Dialog f18079a;

    /* renamed from: b */
    final /* synthetic */ DialogC4937f f18080b;

    C4942k(DialogC4937f dialogC4937f, Dialog dialog) {
        this.f18080b = dialogC4937f;
        this.f18079a = dialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f18080b.f18064u.onClick(this.f18079a, i);
        if (!this.f18080b.f18055l) {
            this.f18079a.dismiss();
        }
    }
}
