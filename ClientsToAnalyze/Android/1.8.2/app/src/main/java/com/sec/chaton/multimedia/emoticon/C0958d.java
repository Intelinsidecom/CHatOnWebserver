package com.sec.chaton.multimedia.emoticon;

import android.database.DataSetObserver;

/* compiled from: AbstractMruAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.d */
/* loaded from: classes.dex */
class C0958d extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ AbstractC0944b f3533a;

    private C0958d(AbstractC0944b abstractC0944b) {
        this.f3533a = abstractC0944b;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.f3533a.f3509c = this.f3533a.f3508b.m6171a();
        this.f3533a.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        this.f3533a.f3509c = null;
        this.f3533a.notifyDataSetInvalidated();
    }
}
