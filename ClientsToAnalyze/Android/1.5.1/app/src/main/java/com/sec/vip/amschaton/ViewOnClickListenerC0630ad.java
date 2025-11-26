package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.ad */
/* loaded from: classes.dex */
class ViewOnClickListenerC0630ad implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSFigureSelectionDialog f4239a;

    ViewOnClickListenerC0630ad(AMSFigureSelectionDialog aMSFigureSelectionDialog) {
        this.f4239a = aMSFigureSelectionDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4239a.f3930r.setVisibility(0);
        this.f4239a.f3931s.setVisibility(8);
        this.f4239a.f3932t.setVisibility(4);
    }
}
