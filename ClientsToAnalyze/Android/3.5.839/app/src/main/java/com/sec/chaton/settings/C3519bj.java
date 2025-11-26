package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.block.BlockActivity;

/* compiled from: ActivityManageBuddy.java */
/* renamed from: com.sec.chaton.settings.bj */
/* loaded from: classes.dex */
class C3519bj implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityManageBuddy f13007a;

    C3519bj(ActivityManageBuddy activityManageBuddy) {
        this.f13007a = activityManageBuddy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f13007a.startActivity(new Intent(this.f13007a.f12537b, (Class<?>) BlockActivity.class));
        return true;
    }
}
