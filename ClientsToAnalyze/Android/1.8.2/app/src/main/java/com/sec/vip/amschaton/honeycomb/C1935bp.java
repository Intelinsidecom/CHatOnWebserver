package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bp */
/* loaded from: classes.dex */
class C1935bp implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f7075a;

    C1935bp(AMSSamplesActivity aMSSamplesActivity) {
        this.f7075a = aMSSamplesActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        this.f7075a.f7001r = i;
        this.f7075a.openContextMenu(this.f7075a.f6997n);
        return true;
    }
}
