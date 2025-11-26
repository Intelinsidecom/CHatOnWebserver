package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.util.C1739av;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.aw */
/* loaded from: classes.dex */
class ViewOnClickListenerC1537aw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f5587a;

    ViewOnClickListenerC1537aw(TrunkItemView trunkItemView) {
        this.f5587a = trunkItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1739av.m5927a() && this.f5587a.f5488g != null) {
            this.f5587a.f5488g.mo5222a(this.f5587a.f5452D, this.f5587a.f5454F);
        }
    }
}
