package com.sec.chaton.trunk;

import android.widget.AbsListView;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.bl */
/* loaded from: classes.dex */
class C4620bl implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC4619bk f16795a;

    C4620bl(HandlerC4619bk handlerC4619bk) {
        this.f16795a = handlerC4619bk;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f16795a.f16794a.f16535W != null && !this.f16795a.f16794a.f16530R && !this.f16795a.f16794a.f16526N && this.f16795a.f16794a.f16520H > 100 && i + i2 >= i3) {
            int iM10677a = C2471v.m10677a(GlobalApplication.m18732r());
            if (-3 == iM10677a || -2 == iM10677a) {
                this.f16795a.f16794a.m17361a(EnumC4629bu.Nonetwork);
            } else {
                this.f16795a.f16794a.m17362a((Boolean) true);
                this.f16795a.f16794a.f16535W.mo17599a(this.f16795a.f16794a.f16525M, 100);
            }
            C4904y.m18645d("Load more comments", TrunkItemView.f16512a);
        }
    }
}
