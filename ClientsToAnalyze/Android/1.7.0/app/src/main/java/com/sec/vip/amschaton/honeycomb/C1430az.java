package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.az */
/* loaded from: classes.dex */
class C1430az implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f5063a;

    C1430az(AMSSamplesActivity aMSSamplesActivity) {
        this.f5063a = aMSSamplesActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        this.f5063a.f5016p = i;
        this.f5063a.openContextMenu(this.f5063a.f5012b);
        return true;
    }
}
