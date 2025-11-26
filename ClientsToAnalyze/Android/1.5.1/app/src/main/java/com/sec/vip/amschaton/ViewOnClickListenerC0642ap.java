package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.ap */
/* loaded from: classes.dex */
class ViewOnClickListenerC0642ap implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSTextSelectionDialog f4252a;

    ViewOnClickListenerC0642ap(AMSTextSelectionDialog aMSTextSelectionDialog) {
        this.f4252a = aMSTextSelectionDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4252a.f4073m.setVisibility(0);
        this.f4252a.f4074n.setVisibility(8);
        this.f4252a.f4075o.setVisibility(4);
    }
}
