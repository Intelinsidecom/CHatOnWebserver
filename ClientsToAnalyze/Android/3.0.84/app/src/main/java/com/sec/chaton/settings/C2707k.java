package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.k */
/* loaded from: classes.dex */
class C2707k implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f10013a;

    C2707k(ActivityChat activityChat) {
        this.f10013a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f10013a.startActivity(new Intent(this.f10013a.f8941c, (Class<?>) ActivityFontChange.class));
        return true;
    }
}
