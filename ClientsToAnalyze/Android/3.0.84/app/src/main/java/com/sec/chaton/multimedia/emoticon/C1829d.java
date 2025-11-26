package com.sec.chaton.multimedia.emoticon;

import android.database.DataSetObserver;

/* compiled from: AbstractMruAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.d */
/* loaded from: classes.dex */
class C1829d extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ AbstractC1827b f6818a;

    private C1829d(AbstractC1827b abstractC1827b) {
        this.f6818a = abstractC1827b;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.f6818a.f6816c = this.f6818a.f6815b.m11720a();
        this.f6818a.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        this.f6818a.f6816c = null;
        this.f6818a.notifyDataSetInvalidated();
    }
}
