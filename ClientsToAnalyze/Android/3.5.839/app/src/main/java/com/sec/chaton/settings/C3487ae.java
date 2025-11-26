package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.ae */
/* loaded from: classes.dex */
class C3487ae implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f12975a;

    C3487ae(ActivityChat activityChat) {
        this.f12975a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f12975a.startActivity(new Intent(this.f12975a.f12502b, (Class<?>) ActivityFontChange.class));
        return true;
    }
}
