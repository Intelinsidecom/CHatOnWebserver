package com.sec.chaton.multimedia.emoticon;

import android.database.DataSetObserver;

/* compiled from: AbsEmoticonContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.a */
/* loaded from: classes.dex */
class C1803a extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ AbsEmoticonContainer f6721a;

    C1803a(AbsEmoticonContainer absEmoticonContainer) {
        this.f6721a = absEmoticonContainer;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        if (this.f6721a.f6694d.isEmpty()) {
            this.f6721a.m7429c();
        } else {
            this.f6721a.m7427b();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        this.f6721a.m7429c();
    }
}
