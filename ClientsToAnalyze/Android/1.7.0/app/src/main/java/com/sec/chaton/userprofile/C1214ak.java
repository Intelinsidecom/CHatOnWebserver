package com.sec.chaton.userprofile;

import android.widget.CompoundButton;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;

/* compiled from: PhoneNumberPrivacyFragment.java */
/* renamed from: com.sec.chaton.userprofile.ak */
/* loaded from: classes.dex */
class C1214ak implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ PhoneNumberPrivacyFragment f4291a;

    C1214ak(PhoneNumberPrivacyFragment phoneNumberPrivacyFragment) {
        this.f4291a = phoneNumberPrivacyFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f4291a.f4170f.setButtonEnabled(z != C1323bs.m4575a().getBoolean("show_phone_number_to_all", false));
        if (z) {
            this.f4291a.f4169e.setText(R.string.phone_number_privacy_guide);
        } else {
            this.f4291a.f4169e.setText(R.string.phone_number_privacy_guide_off);
        }
    }
}
