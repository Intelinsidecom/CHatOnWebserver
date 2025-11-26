package com.sec.common.p123a;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.j */
/* loaded from: classes.dex */
class C4941j implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ Dialog f18077a;

    /* renamed from: b */
    final /* synthetic */ DialogC4937f f18078b;

    C4941j(DialogC4937f dialogC4937f, Dialog dialog) {
        this.f18078b = dialogC4937f;
        this.f18077a = dialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f18078b.f18064u.onClick(this.f18077a, i);
    }
}
