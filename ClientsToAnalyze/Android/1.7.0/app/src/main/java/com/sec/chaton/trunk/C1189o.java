package com.sec.chaton.trunk;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import com.sec.chaton.util.C1341p;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.o */
/* loaded from: classes.dex */
class C1189o extends AsyncQueryHandler {

    /* renamed from: a */
    final /* synthetic */ C1105ac f4058a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1189o(C1105ac c1105ac, ContentResolver contentResolver) {
        super(contentResolver);
        this.f4058a = c1105ac;
    }

    @Override // android.content.AsyncQueryHandler
    protected void onDeleteComplete(int i, Object obj, int i2) {
        super.onDeleteComplete(i, obj, i2);
        if (C1341p.f4578b) {
            C1341p.m4658b("Clear trunk item is completed.", C1105ac.f3884c);
        }
        this.f4058a.f3897p = null;
        if (this.f4058a.f3889g == null) {
            this.f4058a.m4138k();
        } else {
            this.f4058a.f3895m = this.f4058a.f3886d.getLoaderManager().initLoader(0, null, this.f4058a);
        }
    }
}
