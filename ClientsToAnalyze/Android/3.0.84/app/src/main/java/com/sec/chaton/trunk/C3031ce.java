package com.sec.chaton.trunk;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.ce */
/* loaded from: classes.dex */
class C3031ce extends AsyncQueryHandler {

    /* renamed from: a */
    final /* synthetic */ C3018bz f10912a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3031ce(C3018bz c3018bz, ContentResolver contentResolver) {
        super(contentResolver);
        this.f10912a = c3018bz;
    }

    @Override // android.content.AsyncQueryHandler
    protected void onDeleteComplete(int i, Object obj, int i2) {
        super.onDeleteComplete(i, obj, i2);
        if (C3250y.f11734b) {
            C3250y.m11450b("Clear trunk item is completed.", C3018bz.f10879c);
        }
        this.f10912a.f10893q = null;
        if (this.f10912a.f10884g == null) {
            this.f10912a.m10520k();
        } else {
            this.f10912a.f10891n = this.f10912a.f10881d.getLoaderManager().initLoader(0, null, this.f10912a);
        }
    }
}
