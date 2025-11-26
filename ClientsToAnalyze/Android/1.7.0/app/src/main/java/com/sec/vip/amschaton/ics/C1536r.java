package com.sec.vip.amschaton.ics;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.r */
/* loaded from: classes.dex */
class C1536r implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f5364a;

    C1536r(AMSSamplesActivity aMSSamplesActivity) {
        this.f5364a = aMSSamplesActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        this.f5364a.f5261q = i;
        this.f5364a.openContextMenu(this.f5364a.f5256b);
        return true;
    }
}
