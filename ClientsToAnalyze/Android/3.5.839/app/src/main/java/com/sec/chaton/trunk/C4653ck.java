package com.sec.chaton.trunk;

import android.widget.AbsListView;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.ck */
/* loaded from: classes.dex */
class C4653ck implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC4652cj f16864a;

    C4653ck(HandlerC4652cj handlerC4652cj) {
        this.f16864a = handlerC4652cj;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i + i2 >= i3 && this.f16864a.f16863a.f16631b && i3 != 0 && i2 != 0) {
            C4904y.m18641c("!!!!True!!!!", this.f16864a.f16863a.getClass().getSimpleName());
            int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
            if (-3 == iM10677a || -2 == iM10677a) {
                this.f16864a.f16863a.m17470a(EnumC4660cr.Nonetwork);
            } else if (this.f16864a.f16863a.f16652x == null && this.f16864a.f16863a.f16615B != null) {
                this.f16864a.f16863a.m17472a(this.f16864a.f16863a.f16615B);
            }
        }
    }
}
