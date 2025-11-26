package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/* compiled from: AMSBgFrameSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.r */
/* loaded from: classes.dex */
class C1459r implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ GridView f5105a;

    /* renamed from: b */
    final /* synthetic */ AMSBgFrameSelectionActivity f5106b;

    C1459r(AMSBgFrameSelectionActivity aMSBgFrameSelectionActivity, GridView gridView) {
        this.f5106b = aMSBgFrameSelectionActivity;
        this.f5105a = gridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) throws Throwable {
        if (i == 0) {
            this.f5106b.f4931f = -1;
            this.f5106b.m5024e();
        } else {
            if (i == 14) {
                this.f5106b.m5021c();
                return;
            }
            this.f5105a.setEnabled(false);
            this.f5106b.f4931f = i - 2;
            if (i == 1) {
                this.f5106b.f4931f = -3;
            }
            this.f5106b.f4933h.m5273a();
            this.f5106b.m5026f();
        }
    }
}
