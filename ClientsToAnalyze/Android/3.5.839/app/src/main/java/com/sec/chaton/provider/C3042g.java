package com.sec.chaton.provider;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.sec.chaton.search.C3410d;
import com.sec.chaton.search.InterfaceC3412f;

/* compiled from: SuggestionsProvider.java */
/* renamed from: com.sec.chaton.provider.g */
/* loaded from: classes.dex */
class C3042g implements InterfaceC3412f {

    /* renamed from: a */
    final /* synthetic */ SuggestionsProvider f11288a;

    C3042g(SuggestionsProvider suggestionsProvider) {
        this.f11288a = suggestionsProvider;
    }

    @Override // com.sec.chaton.search.InterfaceC3412f
    /* renamed from: a */
    public MatrixCursor mo12498a(Cursor cursor, C3410d c3410d) {
        return this.f11288a.m12454b(cursor, c3410d);
    }
}
