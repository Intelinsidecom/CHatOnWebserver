package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import android.view.View;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC1522d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5350a;

    ViewOnClickListenerC1522d(AMSComposerActivity aMSComposerActivity) {
        this.f5350a = aMSComposerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        if (this.f5350a.f5191L != null) {
            this.f5350a.f5191L.mo4927b();
            this.f5350a.m5407l(false);
        }
    }
}
