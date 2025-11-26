package com.sec.chaton.trunk;

import android.view.View;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ac */
/* loaded from: classes.dex */
class ViewOnClickListenerC4578ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f16688a;

    ViewOnClickListenerC4578ac(TrunkCommentView trunkCommentView) {
        this.f16688a = trunkCommentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((TrunkDetailActivity) this.f16688a.getActivity()).m17306f();
    }
}
