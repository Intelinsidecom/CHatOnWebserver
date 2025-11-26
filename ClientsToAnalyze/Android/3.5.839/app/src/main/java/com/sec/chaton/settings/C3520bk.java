package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityManageBuddy.java */
/* renamed from: com.sec.chaton.settings.bk */
/* loaded from: classes.dex */
class C3520bk implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityManageBuddy f13008a;

    C3520bk(ActivityManageBuddy activityManageBuddy) {
        this.f13008a = activityManageBuddy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f13008a.startActivity(new Intent(this.f13008a.f12537b, (Class<?>) SuggestionsActivity.class));
        return true;
    }
}
