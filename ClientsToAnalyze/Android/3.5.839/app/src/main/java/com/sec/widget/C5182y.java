package com.sec.widget;

import android.database.DataSetObserver;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.y */
/* loaded from: classes.dex */
class C5182y extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ HorizontalListView f18971a;

    C5182y(HorizontalListView horizontalListView) {
        this.f18971a = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f18971a.post(new RunnableC5183z(this));
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f18971a.post(new RunnableC5138aa(this));
    }
}
