package com.sec.vip.amschaton.ics;

import android.view.View;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC1521c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5349a;

    ViewOnClickListenerC1521c(AMSComposerActivity aMSComposerActivity) {
        this.f5349a = aMSComposerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5349a.f5205Z.setButtonEnabled(true);
        if (this.f5349a.f5191L != null) {
            this.f5349a.f5191L.mo4926a();
        }
    }
}
