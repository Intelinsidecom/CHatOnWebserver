package com.sec.widget;

import android.database.DataSetObserver;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.aa */
/* loaded from: classes.dex */
class C1604aa extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ HorizontalListView f5694a;

    C1604aa(HorizontalListView horizontalListView) {
        this.f5694a = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f5694a.post(new RunnableC1607ad(this));
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f5694a.post(new RunnableC1608ae(this));
    }
}
