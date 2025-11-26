package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.ax */
/* loaded from: classes.dex */
class ViewOnClickListenerC0650ax implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BackgroundColorSelectionDialog f4264a;

    ViewOnClickListenerC0650ax(BackgroundColorSelectionDialog backgroundColorSelectionDialog) {
        this.f4264a = backgroundColorSelectionDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4264a.f4112f.setVisibility(0);
        this.f4264a.f4113g.setVisibility(8);
        this.f4264a.f4117k.setVisibility(4);
    }
}
