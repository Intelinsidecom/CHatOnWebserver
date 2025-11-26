package com.sec.chaton.provider;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.sec.chaton.search.C3410d;
import com.sec.chaton.search.InterfaceC3412f;

/* compiled from: SuggestionsProvider.java */
/* renamed from: com.sec.chaton.provider.f */
/* loaded from: classes.dex */
class C3041f implements InterfaceC3412f {

    /* renamed from: a */
    final /* synthetic */ SuggestionsProvider f11287a;

    C3041f(SuggestionsProvider suggestionsProvider) {
        this.f11287a = suggestionsProvider;
    }

    @Override // com.sec.chaton.search.InterfaceC3412f
    /* renamed from: a */
    public MatrixCursor mo12498a(Cursor cursor, C3410d c3410d) {
        return this.f11287a.m12450a(cursor, c3410d);
    }
}
