package com.sec.chaton.userprofile;

import android.view.View;

/* compiled from: CoverStorySampleAdapter.java */
/* renamed from: com.sec.chaton.userprofile.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC4790i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f17516a;

    /* renamed from: b */
    final /* synthetic */ C4789h f17517b;

    ViewOnClickListenerC4790i(C4789h c4789h, int i) {
        this.f17517b = c4789h;
        this.f17516a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f17517b.f17515g != null && !this.f17517b.f17509a.isEmpty() && this.f17516a > -1 && this.f17516a < this.f17517b.f17509a.size()) {
            this.f17517b.f17515g.mo17817a((C4792k) this.f17517b.f17509a.get(this.f17516a));
        }
    }
}
