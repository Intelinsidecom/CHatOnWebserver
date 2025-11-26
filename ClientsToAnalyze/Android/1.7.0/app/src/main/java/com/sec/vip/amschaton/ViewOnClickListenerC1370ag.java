package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.ag */
/* loaded from: classes.dex */
class ViewOnClickListenerC1370ag implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1395be f4814a;

    ViewOnClickListenerC1370ag(C1395be c1395be) {
        this.f4814a = c1395be;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 15; i++) {
            if (this.f4814a.f4891h[i] == view) {
                this.f4814a.m4990b(this.f4814a.m4993c(this.f4814a.f4890g), false);
                this.f4814a.m5000b(this.f4814a.m5646a().getResources().getColor(this.f4814a.f4894k[i]));
                this.f4814a.f5418d.mo4927b();
                return;
            }
        }
    }
}
