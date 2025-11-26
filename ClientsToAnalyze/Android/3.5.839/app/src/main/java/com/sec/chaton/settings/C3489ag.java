package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.ag */
/* loaded from: classes.dex */
class C3489ag implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f12977a;

    C3489ag(ActivityChat activityChat) {
        this.f12977a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f12977a.f12504d = false;
            this.f12977a.f12503c.m18125b("Setting enter key", (Boolean) false);
        } else {
            this.f12977a.f12504d = true;
            this.f12977a.f12503c.m18125b("Setting enter key", (Boolean) true);
        }
        return true;
    }
}
