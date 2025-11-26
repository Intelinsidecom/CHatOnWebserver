package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ab */
/* loaded from: classes.dex */
class C1894ab implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f7020a;

    C1894ab(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f7020a = aMSMyWorksActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        this.f7020a.f6969s = i;
        this.f7020a.openContextMenu(this.f7020a.f6964n);
        return true;
    }
}
