package com.sec.chaton.trunk;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.ci */
/* loaded from: classes.dex */
class C4651ci extends AsyncQueryHandler {

    /* renamed from: a */
    final /* synthetic */ C4646cd f16862a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4651ci(C4646cd c4646cd, ContentResolver contentResolver) {
        super(contentResolver);
        this.f16862a = c4646cd;
    }

    @Override // android.content.AsyncQueryHandler
    protected void onDeleteComplete(int i, Object obj, int i2) {
        super.onDeleteComplete(i, obj, i2);
        if (C4904y.f17872b) {
            C4904y.m18639b("Clear trunk item is completed.", C4646cd.f16842c);
        }
        this.f16862a.f16856q = null;
        if (this.f16862a.f16847g == null) {
            this.f16862a.m17635k();
        } else {
            this.f16862a.f16854n = this.f16862a.f16844d.getLoaderManager().mo108a(0, null, this.f16862a);
        }
    }
}
