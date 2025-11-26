package com.sec.chaton.userprofile;

import android.view.View;
import com.sec.chaton.p013a.C0202ao;

/* compiled from: PhoneNumberPrivacyFragment.java */
/* renamed from: com.sec.chaton.userprofile.al */
/* loaded from: classes.dex */
class ViewOnClickListenerC1215al implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PhoneNumberPrivacyFragment f4292a;

    ViewOnClickListenerC1215al(PhoneNumberPrivacyFragment phoneNumberPrivacyFragment) {
        this.f4292a = phoneNumberPrivacyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new C0202ao(this.f4292a.f4172h).m766b(this.f4292a.f4167c.isChecked());
        this.f4292a.f4168d.show();
    }
}
