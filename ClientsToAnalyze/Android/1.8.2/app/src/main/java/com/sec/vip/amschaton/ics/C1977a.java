package com.sec.vip.amschaton.ics;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/* compiled from: AMSBgFrameSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.a */
/* loaded from: classes.dex */
class C1977a implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ GridView f7244a;

    /* renamed from: b */
    final /* synthetic */ AMSBgFrameSelectionActivity f7245b;

    C1977a(AMSBgFrameSelectionActivity aMSBgFrameSelectionActivity, GridView gridView) {
        this.f7245b = aMSBgFrameSelectionActivity;
        this.f7244a = gridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) throws Throwable {
        if (i == 0) {
            this.f7245b.f7134f = -1;
            this.f7245b.m6872e();
        } else {
            if (i == 13) {
                this.f7245b.m6869c();
                return;
            }
            this.f7244a.setEnabled(false);
            this.f7245b.f7134f = i - 1;
            this.f7245b.f7136h.m7171a();
            this.f7245b.m6874f();
        }
    }
}
