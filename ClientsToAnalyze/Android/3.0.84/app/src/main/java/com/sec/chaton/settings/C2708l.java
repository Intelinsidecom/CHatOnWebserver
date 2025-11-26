package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.l */
/* loaded from: classes.dex */
class C2708l implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f10014a;

    C2708l(ActivityChat activityChat) {
        this.f10014a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f10014a.startActivity(new Intent(this.f10014a.f8941c, (Class<?>) ActivityChatView.class));
        return true;
    }
}
