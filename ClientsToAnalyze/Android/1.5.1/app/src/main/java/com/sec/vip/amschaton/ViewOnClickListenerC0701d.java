package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC0701d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSPenSelectionDialog f4323a;

    ViewOnClickListenerC0701d(AMSPenSelectionDialog aMSPenSelectionDialog) {
        this.f4323a = aMSPenSelectionDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4323a.f4013n.setVisibility(0);
        this.f4323a.f4014o.setVisibility(8);
        this.f4323a.f4015p.setVisibility(4);
    }
}
