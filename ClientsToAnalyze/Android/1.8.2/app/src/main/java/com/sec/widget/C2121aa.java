package com.sec.widget;

import android.database.DataSetObserver;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.aa */
/* loaded from: classes.dex */
class C2121aa extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ HorizontalListView f7762a;

    C2121aa(HorizontalListView horizontalListView) {
        this.f7762a = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f7762a.post(new RunnableC2122ab(this));
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f7762a.post(new RunnableC2123ac(this));
    }
}
