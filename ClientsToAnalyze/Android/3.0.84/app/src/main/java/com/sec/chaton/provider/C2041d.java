package com.sec.chaton.provider;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.sec.chaton.search.C2382d;
import com.sec.chaton.search.InterfaceC2384f;

/* compiled from: SuggestionsProvider.java */
/* renamed from: com.sec.chaton.provider.d */
/* loaded from: classes.dex */
class C2041d implements InterfaceC2384f {

    /* renamed from: a */
    final /* synthetic */ SuggestionsProvider f7877a;

    C2041d(SuggestionsProvider suggestionsProvider) {
        this.f7877a = suggestionsProvider;
    }

    @Override // com.sec.chaton.search.InterfaceC2384f
    /* renamed from: a */
    public MatrixCursor mo8155a(Cursor cursor, C2382d c2382d) {
        return this.f7877a.m8115b(cursor, c2382d);
    }
}
