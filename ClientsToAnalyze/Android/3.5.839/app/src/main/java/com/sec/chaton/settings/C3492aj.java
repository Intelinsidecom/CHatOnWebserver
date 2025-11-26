package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.aj */
/* loaded from: classes.dex */
class C3492aj implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f12980a;

    C3492aj(ActivityChat activityChat) {
        this.f12980a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f12980a.m13376b();
        return true;
    }
}
