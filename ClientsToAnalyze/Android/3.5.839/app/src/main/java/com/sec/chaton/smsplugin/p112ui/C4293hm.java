package com.sec.chaton.smsplugin.p112ui;

import android.widget.TextView;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.InterfaceC3788g;

/* compiled from: SearchActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hm */
/* loaded from: classes.dex */
class C4293hm implements InterfaceC3788g {

    /* renamed from: a */
    final /* synthetic */ SearchActivity f15677a;

    C4293hm(SearchActivity searchActivity) {
        this.f15677a = searchActivity;
    }

    @Override // com.sec.chaton.smsplugin.p102b.InterfaceC3788g
    /* renamed from: a */
    public void mo14300a(C3782a c3782a) {
        TextView textView = (TextView) this.f15677a.f15096c.get(c3782a);
        if (textView != null) {
            textView.setText(c3782a.m14266h());
        }
    }
}
