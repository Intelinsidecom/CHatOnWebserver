package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC0626a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSPenSelectionDialog f4235a;

    ViewOnClickListenerC0626a(AMSPenSelectionDialog aMSPenSelectionDialog) {
        this.f4235a = aMSPenSelectionDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4235a.f4016q[14] == view) {
            this.f4235a.f4013n.setVisibility(8);
            this.f4235a.f4014o.setVisibility(0);
            this.f4235a.f4015p.setVisibility(0);
            return;
        }
        for (int i = 0; i < 14; i++) {
            if (this.f4235a.f4016q[i] == view) {
                this.f4235a.m3990b(this.f4235a.m3998f(this.f4235a.f4006g[this.f4235a.f4005f]), false);
                this.f4235a.m4007b(this.f4235a.getContext().getResources().getColor(this.f4235a.f4018s[i]));
                this.f4235a.m3995e();
                return;
            }
        }
    }
}
