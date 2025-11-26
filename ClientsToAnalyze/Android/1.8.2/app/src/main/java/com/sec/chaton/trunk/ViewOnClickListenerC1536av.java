package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.util.C1786r;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.av */
/* loaded from: classes.dex */
class ViewOnClickListenerC1536av implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f5586a;

    ViewOnClickListenerC1536av(TrunkItemView trunkItemView) {
        this.f5586a = trunkItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f5586a.f5473Y != null) {
            if (!this.f5586a.f5464P) {
                this.f5586a.m5285l();
                this.f5586a.f5473Y.mo5391a(this.f5586a.f5463O, this.f5586a.f5458J);
            } else {
                C1786r.m6065d("Already all comments are loaded.", TrunkItemView.f5448e);
            }
        }
    }
}
