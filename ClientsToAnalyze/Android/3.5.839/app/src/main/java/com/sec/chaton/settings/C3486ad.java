package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.ad */
/* loaded from: classes.dex */
class C3486ad implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f12974a;

    C3486ad(ActivityChat activityChat) {
        this.f12974a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent(this.f12974a.f12502b, (Class<?>) ActivityBgBubbleChange.class);
        intent.putExtra("type", "all_chat");
        this.f12974a.startActivity(intent);
        return false;
    }
}
