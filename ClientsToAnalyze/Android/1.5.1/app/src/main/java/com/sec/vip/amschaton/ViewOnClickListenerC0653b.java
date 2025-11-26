package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0653b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSPenSelectionDialog f4267a;

    ViewOnClickListenerC0653b(AMSPenSelectionDialog aMSPenSelectionDialog) {
        this.f4267a = aMSPenSelectionDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 4; i++) {
            if (this.f4267a.f4008i[i] == view) {
                this.f4267a.m4004a(i);
                this.f4267a.m3995e();
                return;
            }
        }
    }
}
