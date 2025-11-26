package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;

/* compiled from: NewDisclaimerView.java */
/* renamed from: com.sec.chaton.registration.bo */
/* loaded from: classes.dex */
class ViewOnClickListenerC1188bo implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NewDisclaimerView f4398a;

    ViewOnClickListenerC1188bo(NewDisclaimerView newDisclaimerView) {
        this.f4398a = newDisclaimerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4398a.setResult(-1, new Intent());
        this.f4398a.finish();
    }
}
