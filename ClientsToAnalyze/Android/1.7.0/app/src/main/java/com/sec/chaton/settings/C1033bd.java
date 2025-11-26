package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.bd */
/* loaded from: classes.dex */
class C1033bd implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f3637a;

    C1033bd(ActivityChat activityChat) {
        this.f3637a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent(this.f3637a.f3429c, (Class<?>) ActivityBubbleChange.class);
        intent.putExtra("change_mode", "change_bubble");
        this.f3637a.startActivity(intent);
        return true;
    }
}
