package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.util.C4892m;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.cx */
/* loaded from: classes.dex */
class C3560cx implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f13049a;

    C3560cx(ActivityPrivacy activityPrivacy) {
        this.f13049a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (!this.f13049a.f12641s[this.f13049a.f12642t].equals(C4892m.m18588h())) {
            Intent intent = new Intent(this.f13049a, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "PRIVACY");
            this.f13049a.startActivity(intent);
            return false;
        }
        this.f13049a.startActivity(new Intent(this.f13049a, (Class<?>) ActivityPasswordLockView.class));
        return false;
    }
}
