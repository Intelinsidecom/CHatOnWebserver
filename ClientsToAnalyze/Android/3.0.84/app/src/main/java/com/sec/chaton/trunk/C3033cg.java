package com.sec.chaton.trunk;

import android.widget.AbsListView;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.cg */
/* loaded from: classes.dex */
class C3033cg implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3032cf f10914a;

    C3033cg(HandlerC3032cf handlerC3032cf) {
        this.f10914a = handlerC3032cf;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i + i2 >= i3 && this.f10914a.f10913a.f10686b && i3 != 0 && i2 != 0) {
            C3250y.m11453c("!!!!True!!!!", this.f10914a.f10913a.getClass().getSimpleName());
            if (this.f10914a.f10913a.f10707x == null && this.f10914a.f10913a.f10667B != null) {
                this.f10914a.f10913a.m10374a(this.f10914a.f10913a.f10667B);
            }
        }
    }
}
