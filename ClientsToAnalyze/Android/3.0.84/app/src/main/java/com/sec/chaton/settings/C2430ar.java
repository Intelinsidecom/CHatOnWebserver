package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.block.BlockActivity;

/* compiled from: ActivityManageBuddy.java */
/* renamed from: com.sec.chaton.settings.ar */
/* loaded from: classes.dex */
class C2430ar implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityManageBuddy f9290a;

    C2430ar(ActivityManageBuddy activityManageBuddy) {
        this.f9290a = activityManageBuddy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9290a.startActivity(new Intent(this.f9290a.f8992b, (Class<?>) BlockActivity.class));
        return true;
    }
}
