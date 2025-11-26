package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.y */
/* loaded from: classes.dex */
class ViewOnClickListenerC0722y implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSFigureSelectionDialog f4356a;

    ViewOnClickListenerC0722y(AMSFigureSelectionDialog aMSFigureSelectionDialog) {
        this.f4356a = aMSFigureSelectionDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 6; i++) {
            if (this.f4356a.f3921i[i] == view) {
                this.f4356a.m3891a(i);
                return;
            }
        }
    }
}
