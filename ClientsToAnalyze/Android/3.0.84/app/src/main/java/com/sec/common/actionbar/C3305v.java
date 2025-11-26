package com.sec.common.actionbar;

import android.view.View;
import com.sec.common.actionbar.TabContainerView;

/* compiled from: TabContainerView.java */
/* renamed from: com.sec.common.actionbar.v */
/* loaded from: classes.dex */
class C3305v implements InterfaceC3297n {

    /* renamed from: a */
    final /* synthetic */ TabContainerView.TabView f11967a;

    /* renamed from: b */
    final /* synthetic */ TabContainerView f11968b;

    C3305v(TabContainerView tabContainerView, TabContainerView.TabView tabView) {
        this.f11968b = tabContainerView;
        this.f11967a = tabView;
    }

    @Override // com.sec.common.actionbar.InterfaceC3297n
    /* renamed from: a */
    public void mo11632a(View view) {
        this.f11967a.setCustomView(view);
    }
}
