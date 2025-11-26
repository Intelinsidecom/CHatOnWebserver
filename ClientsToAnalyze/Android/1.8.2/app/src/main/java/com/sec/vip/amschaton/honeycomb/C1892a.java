package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/* compiled from: AMSBgFrameSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.a */
/* loaded from: classes.dex */
class C1892a implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ GridView f7017a;

    /* renamed from: b */
    final /* synthetic */ AMSBgFrameSelectionActivity f7018b;

    C1892a(AMSBgFrameSelectionActivity aMSBgFrameSelectionActivity, GridView gridView) {
        this.f7018b = aMSBgFrameSelectionActivity;
        this.f7017a = gridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (i == 0) {
            this.f7018b.f6907r = -1;
            this.f7018b.m6548i();
        } else {
            if (i == 14) {
                this.f7018b.m6546g();
                return;
            }
            this.f7017a.setEnabled(false);
            this.f7018b.f6907r = i - 2;
            if (i == 1) {
                this.f7018b.f6907r = -3;
            }
            this.f7018b.f6909t.m6858a();
            this.f7018b.m6549j();
        }
    }
}
