package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityBuddyView.java */
/* renamed from: com.sec.chaton.settings.e */
/* loaded from: classes.dex */
class C1326e implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityBuddyView f4902a;

    C1326e(ActivityBuddyView activityBuddyView) {
        this.f4902a = activityBuddyView;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f4902a.f4461f = false;
            this.f4902a.f4457b.putBoolean("Profile Birth Chk", false).commit();
        } else {
            this.f4902a.f4461f = true;
            this.f4902a.f4457b.putBoolean("Profile Birth Chk", true).commit();
        }
        return true;
    }
}
