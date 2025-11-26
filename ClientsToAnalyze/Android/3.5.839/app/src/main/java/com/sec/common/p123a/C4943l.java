package com.sec.common.p123a;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.l */
/* loaded from: classes.dex */
class C4943l implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ListView f18081a;

    /* renamed from: b */
    final /* synthetic */ Dialog f18082b;

    /* renamed from: c */
    final /* synthetic */ DialogC4937f f18083c;

    C4943l(DialogC4937f dialogC4937f, ListView listView, Dialog dialog) {
        this.f18083c = dialogC4937f;
        this.f18081a = listView;
        this.f18082b = dialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f18083c.f18058o != null) {
            this.f18083c.f18058o[i] = this.f18081a.isItemChecked(i);
        }
        this.f18083c.f18066w.onClick(this.f18082b, i, this.f18081a.isItemChecked(i));
    }
}
