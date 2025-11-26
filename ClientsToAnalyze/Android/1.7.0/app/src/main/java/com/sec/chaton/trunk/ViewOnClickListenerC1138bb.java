package com.sec.chaton.trunk;

import android.view.View;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.bb */
/* loaded from: classes.dex */
class ViewOnClickListenerC1138bb implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f3968a;

    ViewOnClickListenerC1138bb(TrunkCommentView trunkCommentView) {
        this.f3968a = trunkCommentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f3968a.f3755c != null) {
            this.f3968a.f3755c.mo3960c();
        }
    }
}
