package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.af */
/* loaded from: classes.dex */
class C3488af implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f12976a;

    C3488af(ActivityChat activityChat) {
        this.f12976a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f12976a.startActivityForResult(new Intent(this.f12976a.f12502b, (Class<?>) ActivityChatView.class), 0);
        return true;
    }
}
