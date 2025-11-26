package com.sec.chaton.userprofile;

import android.widget.AbsListView;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.av */
/* loaded from: classes.dex */
class C4736av implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f17400a;

    C4736av(MyPageFragment myPageFragment) {
        this.f17400a = myPageFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && this.f17400a.f17214S != null && "true".equals(this.f17400a.f17214S)) {
            if (C4904y.f17872b) {
                C4904y.m18639b("mPostONOnScrollListener()", MyPageFragment.f17192a);
            }
            this.f17400a.f17218W = true;
            this.f17400a.f17207L.m9290a(C4809aa.m18104a().m18121a("chaton_id", ""), this.f17400a.f17215T);
        }
    }
}
