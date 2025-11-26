package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.hide.HideActivity;

/* compiled from: ActivityManageBuddy.java */
/* renamed from: com.sec.chaton.settings.bi */
/* loaded from: classes.dex */
class C3518bi implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityManageBuddy f13006a;

    C3518bi(ActivityManageBuddy activityManageBuddy) {
        this.f13006a = activityManageBuddy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f13006a.startActivity(new Intent(this.f13006a.f12537b, (Class<?>) HideActivity.class));
        return true;
    }
}
