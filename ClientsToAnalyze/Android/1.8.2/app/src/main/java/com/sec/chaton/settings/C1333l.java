package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.l */
/* loaded from: classes.dex */
class C1333l implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f4909a;

    C1333l(ActivityChat activityChat) {
        this.f4909a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f4909a.f4470e = false;
            this.f4909a.f4467b.putBoolean("Setting enter key", false).commit();
        } else {
            this.f4909a.f4470e = true;
            this.f4909a.f4467b.putBoolean("Setting enter key", true).commit();
        }
        return true;
    }
}
