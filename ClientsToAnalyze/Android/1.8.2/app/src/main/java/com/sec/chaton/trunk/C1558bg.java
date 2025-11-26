package com.sec.chaton.trunk;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import com.sec.chaton.util.C1786r;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.bg */
/* loaded from: classes.dex */
class C1558bg extends AsyncQueryHandler {

    /* renamed from: a */
    final /* synthetic */ C1554bc f5635a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1558bg(C1554bc c1554bc, ContentResolver contentResolver) {
        super(contentResolver);
        this.f5635a = c1554bc;
    }

    @Override // android.content.AsyncQueryHandler
    protected void onDeleteComplete(int i, Object obj, int i2) {
        super.onDeleteComplete(i, obj, i2);
        if (C1786r.f6452b) {
            C1786r.m6061b("Clear trunk item is completed.", C1554bc.f5617c);
        }
        this.f5635a.f5630p = null;
        if (this.f5635a.f5622g != null) {
            if (this.f5635a.f5619d != null && this.f5635a.f5619d.getActivity() != null) {
                this.f5635a.f5628m = this.f5635a.f5619d.getLoaderManager().initLoader(0, null, this.f5635a);
                return;
            }
            return;
        }
        this.f5635a.m5423k();
    }
}
