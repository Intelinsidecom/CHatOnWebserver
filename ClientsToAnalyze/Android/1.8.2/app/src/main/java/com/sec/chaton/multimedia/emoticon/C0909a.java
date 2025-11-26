package com.sec.chaton.multimedia.emoticon;

import android.database.DataSetObserver;

/* compiled from: AbsEmoticonContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.a */
/* loaded from: classes.dex */
class C0909a extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ AbsEmoticonContainer f3375a;

    C0909a(AbsEmoticonContainer absEmoticonContainer) {
        this.f3375a = absEmoticonContainer;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        if (this.f3375a.f3348d.isEmpty()) {
            this.f3375a.m3653c();
        } else {
            this.f3375a.m3651b();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        this.f3375a.m3653c();
    }
}
