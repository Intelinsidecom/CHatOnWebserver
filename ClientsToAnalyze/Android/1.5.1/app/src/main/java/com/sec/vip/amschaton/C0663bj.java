package com.sec.vip.amschaton;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: com.sec.vip.amschaton.bj */
/* loaded from: classes.dex */
class C0663bj implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSFileListActivity f4283a;

    C0663bj(AMSFileListActivity aMSFileListActivity) {
        this.f4283a = aMSFileListActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        this.f4283a.m3905a(i, true);
        return true;
    }
}
