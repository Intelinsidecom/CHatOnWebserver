package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityBuddyView.java */
/* renamed from: com.sec.chaton.settings.bx */
/* loaded from: classes.dex */
class C1053bx implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityBuddyView f3664a;

    C1053bx(ActivityBuddyView activityBuddyView) {
        this.f3664a = activityBuddyView;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f3664a.f3425d = false;
            this.f3664a.f3423b.putBoolean("Profile Birth Chk", false).commit();
        } else {
            this.f3664a.f3425d = true;
            this.f3664a.f3423b.putBoolean("Profile Birth Chk", true).commit();
        }
        return true;
    }
}
