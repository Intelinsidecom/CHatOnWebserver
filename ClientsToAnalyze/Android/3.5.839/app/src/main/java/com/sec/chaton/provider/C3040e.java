package com.sec.chaton.provider;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.sec.chaton.search.C3410d;
import com.sec.chaton.search.InterfaceC3412f;

/* compiled from: SuggestionsProvider.java */
/* renamed from: com.sec.chaton.provider.e */
/* loaded from: classes.dex */
class C3040e implements InterfaceC3412f {

    /* renamed from: a */
    final /* synthetic */ SuggestionsProvider f11286a;

    C3040e(SuggestionsProvider suggestionsProvider) {
        this.f11286a = suggestionsProvider;
    }

    @Override // com.sec.chaton.search.InterfaceC3412f
    /* renamed from: a */
    public MatrixCursor mo12498a(Cursor cursor, C3410d c3410d) {
        return this.f11286a.m12456c(cursor, c3410d);
    }
}
