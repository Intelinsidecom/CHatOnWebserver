package com.sec.chaton.userprofile;

import android.widget.CompoundButton;
import com.sec.chaton.R;

/* compiled from: PhoneNumberPrivacyFragment.java */
/* renamed from: com.sec.chaton.userprofile.aw */
/* loaded from: classes.dex */
class C1646aw implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ PhoneNumberPrivacyFragment f6137a;

    C1646aw(PhoneNumberPrivacyFragment phoneNumberPrivacyFragment) {
        this.f6137a = phoneNumberPrivacyFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f6137a.f5951e.setText(this.f6137a.getResources().getString(R.string.phone_number_privacy_guide));
        } else {
            this.f6137a.f5951e.setText(this.f6137a.getResources().getString(R.string.phone_number_privacy_guide_off));
        }
    }
}
