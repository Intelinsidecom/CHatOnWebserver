package com.sec.vip.amschaton.ics;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.aq */
/* loaded from: classes.dex */
class C1486aq implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f5301a;

    C1486aq(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f5301a = aMSMyWorksActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        this.f5301a.f5231r = i;
        this.f5301a.openContextMenu(this.f5301a.f5225b);
        return true;
    }
}
