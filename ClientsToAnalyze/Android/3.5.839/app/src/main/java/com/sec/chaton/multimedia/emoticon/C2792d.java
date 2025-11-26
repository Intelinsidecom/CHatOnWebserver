package com.sec.chaton.multimedia.emoticon;

import android.database.DataSetObserver;

/* compiled from: AbstractMruAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.d */
/* loaded from: classes.dex */
class C2792d extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ AbstractC2790b f10104a;

    private C2792d(AbstractC2790b abstractC2790b) {
        this.f10104a = abstractC2790b;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.f10104a.f10102c = this.f10104a.f10101b.mo11703a();
        this.f10104a.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        this.f10104a.f10102c = null;
        this.f10104a.notifyDataSetInvalidated();
    }
}
