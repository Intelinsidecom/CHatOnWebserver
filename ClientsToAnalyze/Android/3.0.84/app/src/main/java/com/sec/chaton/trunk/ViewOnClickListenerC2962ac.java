package com.sec.chaton.trunk;

import android.view.View;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ac */
/* loaded from: classes.dex */
class ViewOnClickListenerC2962ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f10742a;

    ViewOnClickListenerC2962ac(TrunkCommentView trunkCommentView) {
        this.f10742a = trunkCommentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((TrunkDetailActivity) this.f10742a.getActivity()).m10207c();
    }
}
