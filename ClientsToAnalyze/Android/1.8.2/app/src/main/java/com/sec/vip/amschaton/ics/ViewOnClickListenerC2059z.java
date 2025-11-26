package com.sec.vip.amschaton.ics;

import android.view.View;
import com.sec.widget.C2134f;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.z */
/* loaded from: classes.dex */
class ViewOnClickListenerC2059z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2134f f7355a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7356b;

    ViewOnClickListenerC2059z(AMSComposerActivity aMSComposerActivity, C2134f c2134f) {
        this.f7356b = aMSComposerActivity;
        this.f7355a = c2134f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7355a != null) {
            this.f7355a.m7488a(view);
        }
    }
}
