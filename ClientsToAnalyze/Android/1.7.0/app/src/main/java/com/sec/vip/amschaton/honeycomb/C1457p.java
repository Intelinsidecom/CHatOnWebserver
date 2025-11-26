package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.p */
/* loaded from: classes.dex */
class C1457p implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f5103a;

    C1457p(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f5103a = aMSMyWorksActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        this.f5103a.f4985s = i;
        this.f5103a.openContextMenu(this.f5103a.f4978b);
        return true;
    }
}
