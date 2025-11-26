package com.sec.chaton;

import android.database.DataSetObserver;
import com.sec.common.actionbar.AbstractC3284a;

/* compiled from: FlexibleActivity.java */
/* renamed from: com.sec.chaton.r */
/* loaded from: classes.dex */
class C2119r extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ FlexibleActivity f8057a;

    C2119r(FlexibleActivity flexibleActivity) {
        this.f8057a = flexibleActivity;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        AbstractC3284a abstractC3284aK = this.f8057a.m11543k();
        if (abstractC3284aK != null && abstractC3284aK.mo11578a() == 2) {
            this.f8057a.m1149b(2);
        }
    }
}
