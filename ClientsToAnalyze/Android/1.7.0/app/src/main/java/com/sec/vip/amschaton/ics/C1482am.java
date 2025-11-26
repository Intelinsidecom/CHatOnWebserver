package com.sec.vip.amschaton.ics;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/* compiled from: AMSBgFrameSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.am */
/* loaded from: classes.dex */
class C1482am implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ GridView f5295a;

    /* renamed from: b */
    final /* synthetic */ AMSBgFrameSelectionActivity f5296b;

    C1482am(AMSBgFrameSelectionActivity aMSBgFrameSelectionActivity, GridView gridView) {
        this.f5296b = aMSBgFrameSelectionActivity;
        this.f5295a = gridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) throws Throwable {
        if (i == 0) {
            this.f5296b.f5174f = -1;
            this.f5296b.m5325e();
        } else {
            if (i == 14) {
                this.f5296b.m5322c();
                return;
            }
            this.f5295a.setEnabled(false);
            this.f5296b.f5174f = i - 2;
            if (i == 1) {
                this.f5296b.f5174f = -3;
            }
            this.f5296b.f5176h.m5614a();
            this.f5296b.m5327f();
        }
    }
}
