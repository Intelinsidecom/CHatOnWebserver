package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.userprofile.PhoneNumberPrivacyActivity;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.bk */
/* loaded from: classes.dex */
class C1040bk implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f3651a;

    C1040bk(ActivityPrivacy activityPrivacy) {
        this.f3651a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent(this.f3651a.f3454d, (Class<?>) PhoneNumberPrivacyActivity.class);
        intent.putExtra("extra_phone_number", "+" + this.f3651a.f3459i);
        this.f3651a.startActivity(intent);
        return true;
    }
}
