package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.bc */
/* loaded from: classes.dex */
class C1032bc implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f3636a;

    C1032bc(ActivityChat activityChat) {
        this.f3636a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3636a.startActivity(new Intent(this.f3636a.f3429c, (Class<?>) ActivityChatView.class));
        return true;
    }
}
