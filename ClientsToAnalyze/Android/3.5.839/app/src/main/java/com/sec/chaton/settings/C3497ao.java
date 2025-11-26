package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.global.C2349a;

/* compiled from: ActivityContactSyncFragment.java */
/* renamed from: com.sec.chaton.settings.ao */
/* loaded from: classes.dex */
class C3497ao implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityContactSyncFragment f12985a;

    C3497ao(ActivityContactSyncFragment activityContactSyncFragment) {
        this.f12985a = activityContactSyncFragment;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (this.f12985a.getView() != null) {
            this.f12985a.m60a().invalidateViews();
            if (C2349a.m10301a("support_contact_auto_sync")) {
                preference.setSummary(this.f12985a.m13386d());
                return false;
            }
            preference.setSummary(this.f12985a.m13389e());
            return false;
        }
        return false;
    }
}
