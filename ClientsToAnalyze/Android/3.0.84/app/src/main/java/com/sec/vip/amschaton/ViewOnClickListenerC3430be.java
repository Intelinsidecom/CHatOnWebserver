package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.be */
/* loaded from: classes.dex */
class ViewOnClickListenerC3430be implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3424az f12563a;

    ViewOnClickListenerC3430be(C3424az c3424az) {
        this.f12563a = c3424az;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 15; i++) {
            if (this.f12563a.f12540j[i].equals(view)) {
                this.f12563a.m12254b(this.f12563a.m12258d(this.f12563a.f12539i), false);
                this.f12563a.m12265b(this.f12563a.m12242e().getResources().getColor(this.f12563a.f12543m[i]));
                this.f12563a.f12527e.mo12235b();
                return;
            }
        }
    }
}
