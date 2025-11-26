package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.aa */
/* loaded from: classes.dex */
class ViewOnClickListenerC0627aa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSFigureSelectionDialog f4236a;

    ViewOnClickListenerC0627aa(AMSFigureSelectionDialog aMSFigureSelectionDialog) {
        this.f4236a = aMSFigureSelectionDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4236a.f3933u[14] == view) {
            this.f4236a.f3930r.setVisibility(8);
            this.f4236a.f3931s.setVisibility(0);
            this.f4236a.f3932t.setVisibility(0);
            return;
        }
        for (int i = 0; i < 14; i++) {
            if (this.f4236a.f3933u[i] == view) {
                this.f4236a.m3878b(this.f4236a.m3888h(this.f4236a.f3919g), false);
                this.f4236a.m3893b(this.f4236a.getContext().getResources().getColor(this.f4236a.f3935w[i]));
                this.f4236a.m3883e();
                return;
            }
        }
    }
}
