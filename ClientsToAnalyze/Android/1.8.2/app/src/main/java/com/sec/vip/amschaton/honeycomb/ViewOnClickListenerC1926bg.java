package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;
import android.view.View;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bg */
/* loaded from: classes.dex */
class ViewOnClickListenerC1926bg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7065a;

    ViewOnClickListenerC1926bg(AMSPlayerActivity aMSPlayerActivity) {
        this.f7065a = aMSPlayerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, Resources.NotFoundException {
        if ((this.f7065a.f6688l.m6514g() & 1) == 1) {
            this.f7065a.m6732e(false);
            this.f7065a.m6737g(false);
            this.f7065a.m6763r();
            return;
        }
        this.f7065a.m6744i();
    }
}
