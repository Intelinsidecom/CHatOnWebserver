package com.sec.widget;

import android.database.DataSetObserver;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.al */
/* loaded from: classes.dex */
class C3644al extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ HorizontalListView f13521a;

    C3644al(HorizontalListView horizontalListView) {
        this.f13521a = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f13521a.post(new RunnableC3645am(this));
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f13521a.post(new RunnableC3646an(this));
    }
}
