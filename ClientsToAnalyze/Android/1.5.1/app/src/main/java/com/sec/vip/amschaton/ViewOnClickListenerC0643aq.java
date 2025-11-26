package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.aq */
/* loaded from: classes.dex */
class ViewOnClickListenerC0643aq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSTextSelectionDialog f4253a;

    ViewOnClickListenerC0643aq(AMSTextSelectionDialog aMSTextSelectionDialog) {
        this.f4253a = aMSTextSelectionDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4253a.f4076p[14] == view) {
            this.f4253a.f4073m.setVisibility(8);
            this.f4253a.f4074n.setVisibility(0);
            this.f4253a.f4075o.setVisibility(0);
            return;
        }
        for (int i = 0; i < 14; i++) {
            if (this.f4253a.f4076p[i] == view) {
                this.f4253a.m4091a(this.f4253a.m4097d(this.f4253a.f4067g), false);
                this.f4253a.m4105a(this.f4253a.getContext().getResources().getColor(this.f4253a.f4078r[i]));
                this.f4253a.m4098d();
                return;
            }
        }
    }
}
