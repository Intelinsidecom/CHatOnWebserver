package com.sec.chaton.multimedia.multisend;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: PreviewPageView.java */
/* renamed from: com.sec.chaton.multimedia.multisend.r */
/* loaded from: classes.dex */
class C2884r implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PreviewPageView f10609a;

    C2884r(PreviewPageView previewPageView) {
        this.f10609a = previewPageView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2883q c2883q = (C2883q) view.getTag();
        this.f10609a.f10549e = c2883q.f10606d;
        this.f10609a.f10550f = i;
        if (((PreviewData) this.f10609a.f10546b.get(this.f10609a.f10550f)).m11982d() == null) {
            this.f10609a.m11996a(this.f10609a.f10549e, true);
        } else {
            this.f10609a.m11996a(((PreviewData) this.f10609a.f10546b.get(this.f10609a.f10550f)).m11982d(), false);
        }
    }
}
