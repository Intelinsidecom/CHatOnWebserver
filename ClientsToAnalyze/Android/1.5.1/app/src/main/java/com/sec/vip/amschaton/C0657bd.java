package com.sec.vip.amschaton;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: com.sec.vip.amschaton.bd */
/* loaded from: classes.dex */
class C0657bd implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSFileListActivity f4271a;

    C0657bd(AMSFileListActivity aMSFileListActivity) {
        this.f4271a = aMSFileListActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        this.f4271a.m3905a(i - 1, false);
        return true;
    }
}
