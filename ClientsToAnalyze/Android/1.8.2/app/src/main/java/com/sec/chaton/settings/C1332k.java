package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.k */
/* loaded from: classes.dex */
class C1332k implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f4908a;

    C1332k(ActivityChat activityChat) {
        this.f4908a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f4908a.startActivity(new Intent(this.f4908a.f4468c, (Class<?>) ActivityChatView.class));
        return true;
    }
}
