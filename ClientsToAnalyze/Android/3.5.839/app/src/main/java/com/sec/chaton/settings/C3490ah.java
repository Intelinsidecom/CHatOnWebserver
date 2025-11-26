package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.ah */
/* loaded from: classes.dex */
class C3490ah implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f12978a;

    C3490ah(ActivityChat activityChat) {
        this.f12978a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (obj != null) {
            boolean z = Boolean.parseBoolean(obj.toString());
            this.f12978a.f12503c.m18125b("Setting push to talk", Boolean.valueOf(z));
            if (z) {
            }
            return true;
        }
        return true;
    }
}
