package com.sec.chaton.chat;

import android.database.DataSetObserver;

/* compiled from: SortCursor.java */
/* renamed from: com.sec.chaton.chat.hw */
/* loaded from: classes.dex */
class C1777hw extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ C1776hv f6670a;

    C1777hw(C1776hv c1776hv) {
        this.f6670a = c1776hv;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f6670a.mPos = -1;
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f6670a.mPos = -1;
    }
}
