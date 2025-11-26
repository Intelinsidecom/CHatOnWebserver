package com.sec.chaton.multimedia.multisend;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: PreviewPageView.java */
/* renamed from: com.sec.chaton.multimedia.multisend.r */
/* loaded from: classes.dex */
class C1915r implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PreviewPageView f7288a;

    C1915r(PreviewPageView previewPageView) {
        this.f7288a = previewPageView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C1910m c1910m = (C1910m) view.getTag();
        this.f7288a.f7228e = c1910m.f7284d;
        this.f7288a.f7229f = i;
        if (((PreviewData) this.f7288a.f7225b.get(this.f7288a.f7229f)).m7752d() == null) {
            this.f7288a.m7766a(this.f7288a.f7228e, true);
        } else {
            this.f7288a.m7766a(((PreviewData) this.f7288a.f7225b.get(this.f7288a.f7229f)).m7752d(), false);
        }
    }
}
