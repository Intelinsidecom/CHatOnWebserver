package com.sec.common.actionbar;

import android.view.View;
import com.sec.common.actionbar.TabContainerView;

/* compiled from: TabContainerView.java */
/* renamed from: com.sec.common.actionbar.v */
/* loaded from: classes.dex */
class C4967v implements InterfaceC4959n {

    /* renamed from: a */
    final /* synthetic */ TabContainerView.TabView f18165a;

    /* renamed from: b */
    final /* synthetic */ TabContainerView f18166b;

    C4967v(TabContainerView tabContainerView, TabContainerView.TabView tabView) {
        this.f18166b = tabContainerView;
        this.f18165a = tabView;
    }

    @Override // com.sec.common.actionbar.InterfaceC4959n
    /* renamed from: a */
    public void mo18871a(View view) {
        this.f18165a.setCustomView(view);
    }
}
