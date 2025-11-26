package com.sec.chaton.trunk;

import android.widget.AbsListView;
import com.sec.chaton.util.C1341p;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.an */
/* loaded from: classes.dex */
class C1116an implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1184j f3927a;

    C1116an(HandlerC1184j handlerC1184j) {
        this.f3927a = handlerC1184j;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i + i2 >= i3) {
            if (this.f3927a.f4054a.f3833a) {
                if (i3 != 0 && i2 != 0) {
                    C1341p.m4660c("!!!!True!!!!", this.f3927a.f4054a.getClass().getSimpleName());
                    if (this.f3927a.f4054a.f3852u == null && this.f3927a.f4054a.f3827B != null) {
                        this.f3927a.f4054a.m4061a(this.f3927a.f4054a.f3827B);
                        return;
                    }
                    return;
                }
                return;
            }
            C1341p.m4660c("!!!!false!!!!" + i, this.f3927a.f4054a.getClass().getSimpleName());
        }
    }
}
