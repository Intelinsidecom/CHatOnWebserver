package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityManageBuddy.java */
/* renamed from: com.sec.chaton.settings.as */
/* loaded from: classes.dex */
class C2431as implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityManageBuddy f9291a;

    C2431as(ActivityManageBuddy activityManageBuddy) {
        this.f9291a = activityManageBuddy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9291a.startActivity(new Intent(this.f9291a.f8992b, (Class<?>) SuggestionsActivity.class));
        return true;
    }
}
