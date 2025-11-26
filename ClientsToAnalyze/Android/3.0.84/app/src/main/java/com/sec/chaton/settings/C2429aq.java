package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.hide.HideActivity;

/* compiled from: ActivityManageBuddy.java */
/* renamed from: com.sec.chaton.settings.aq */
/* loaded from: classes.dex */
class C2429aq implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityManageBuddy f9289a;

    C2429aq(ActivityManageBuddy activityManageBuddy) {
        this.f9289a = activityManageBuddy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9289a.startActivity(new Intent(this.f9289a.f8992b, (Class<?>) HideActivity.class));
        return true;
    }
}
