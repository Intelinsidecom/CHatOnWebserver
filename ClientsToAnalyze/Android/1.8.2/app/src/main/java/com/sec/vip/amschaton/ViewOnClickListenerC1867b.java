package com.sec.vip.amschaton;

import android.app.Activity;
import android.view.View;

/* compiled from: AMSActionBarView.java */
/* renamed from: com.sec.vip.amschaton.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC1867b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSActionBarView f6839a;

    ViewOnClickListenerC1867b(AMSActionBarView aMSActionBarView) {
        this.f6839a = aMSActionBarView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getContext() instanceof Activity) {
            ((Activity) view.getContext()).finish();
        }
    }
}
