package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.be */
/* loaded from: classes.dex */
class C1034be implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f3638a;

    C1034be(ActivityChat activityChat) {
        this.f3638a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent(this.f3638a.f3429c, (Class<?>) ActivityBackgroundChange.class);
        intent.putExtra("change_mode", "change_background");
        this.f3638a.startActivity(intent);
        return true;
    }
}
