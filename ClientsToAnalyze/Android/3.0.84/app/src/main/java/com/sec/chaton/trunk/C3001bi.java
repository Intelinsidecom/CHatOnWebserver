package com.sec.chaton.trunk;

import android.widget.AbsListView;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.bi */
/* loaded from: classes.dex */
class C3001bi implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3000bh f10847a;

    C3001bi(HandlerC3000bh handlerC3000bh) {
        this.f10847a = handlerC3000bh;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f10847a.f10846a.f10590Y != null && !this.f10847a.f10846a.f10585T && !this.f10847a.f10846a.f10581P && this.f10847a.f10846a.f10575J > 100 && i + i2 >= i3) {
            int iM6733a = C1594v.m6733a(GlobalApplication.m11493l());
            if (-3 == iM6733a || -2 == iM6733a) {
                this.f10847a.f10846a.m10264a(EnumC3010br.Nonetwork);
            } else if (this.f10847a.f10846a.f10575J > 0) {
                this.f10847a.f10846a.m10265a((Boolean) true);
                this.f10847a.f10846a.f10590Y.mo10501a(this.f10847a.f10846a.f10580O, 100);
            }
            C3250y.m11455d("Load more comments", TrunkItemView.f10565a);
        }
    }
}
