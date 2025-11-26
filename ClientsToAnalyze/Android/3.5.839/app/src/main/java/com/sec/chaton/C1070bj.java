package com.sec.chaton;

import android.database.DataSetObserver;
import com.sec.common.actionbar.AbstractC4946a;

/* compiled from: FlexibleActivity.java */
/* renamed from: com.sec.chaton.bj */
/* loaded from: classes.dex */
class C1070bj extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ FlexibleActivity f3366a;

    C1070bj(FlexibleActivity flexibleActivity) {
        this.f3366a = flexibleActivity;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        AbstractC4946a abstractC4946aT = this.f3366a.m18784t();
        if (abstractC4946aT != null && abstractC4946aT.mo18818a() == 2) {
            this.f3366a.m2903b(2);
        }
    }
}
