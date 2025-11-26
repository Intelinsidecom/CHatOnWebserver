package com.sec.chaton.provider;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.sec.chaton.search.C2382d;
import com.sec.chaton.search.InterfaceC2384f;

/* compiled from: SuggestionsProvider.java */
/* renamed from: com.sec.chaton.provider.e */
/* loaded from: classes.dex */
class C2042e implements InterfaceC2384f {

    /* renamed from: a */
    final /* synthetic */ SuggestionsProvider f7878a;

    C2042e(SuggestionsProvider suggestionsProvider) {
        this.f7878a = suggestionsProvider;
    }

    @Override // com.sec.chaton.search.InterfaceC2384f
    /* renamed from: a */
    public MatrixCursor mo8155a(Cursor cursor, C2382d c2382d) {
        return this.f7878a.m8113a(cursor, c2382d);
    }
}
