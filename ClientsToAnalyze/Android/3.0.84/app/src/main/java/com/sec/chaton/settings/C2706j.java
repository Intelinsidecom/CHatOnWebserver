package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.settings2.PrefFragmentChats;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.j */
/* loaded from: classes.dex */
class C2706j implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f10012a;

    C2706j(ActivityChat activityChat) {
        this.f10012a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent(this.f10012a.f8941c, (Class<?>) ActivityBgBubbleChange.class);
        intent.putExtra(PrefFragmentChats.TYPE, PrefFragmentChats.ALL_CHAT);
        this.f10012a.startActivity(intent);
        return false;
    }
}
