package com.sec.chaton.registration;

import android.view.View;

/* compiled from: NewDisclaimerView.java */
/* renamed from: com.sec.chaton.registration.bm */
/* loaded from: classes.dex */
class ViewOnClickListenerC1186bm implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NewDisclaimerView f4396a;

    ViewOnClickListenerC1186bm(NewDisclaimerView newDisclaimerView) {
        this.f4396a = newDisclaimerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4396a.f4328b.isChecked()) {
            this.f4396a.f4328b.setChecked(false);
        } else {
            this.f4396a.f4328b.setChecked(true);
        }
        this.f4396a.m4443a();
    }
}
