package com.sec.chaton.multimedia.emoticon;

import android.database.DataSetObserver;

/* compiled from: AbsEmoticonContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.a */
/* loaded from: classes.dex */
class C2767a extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ AbsEmoticonContainer f10013a;

    C2767a(AbsEmoticonContainer absEmoticonContainer) {
        this.f10013a = absEmoticonContainer;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        if (this.f10013a.f9986d.isEmpty()) {
            this.f10013a.m11624c();
        } else {
            this.f10013a.m11622b();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        this.f10013a.m11624c();
    }
}
