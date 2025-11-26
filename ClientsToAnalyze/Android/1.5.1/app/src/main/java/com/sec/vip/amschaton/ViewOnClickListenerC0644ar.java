package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.ar */
/* loaded from: classes.dex */
class ViewOnClickListenerC0644ar implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSTextSelectionDialog f4254a;

    ViewOnClickListenerC0644ar(AMSTextSelectionDialog aMSTextSelectionDialog) {
        this.f4254a = aMSTextSelectionDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 5; i++) {
            if (this.f4254a.f4072l[i] == view) {
                this.f4254a.m4107b(i);
                return;
            }
        }
    }
}
