package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.global.C1493a;

/* compiled from: ActivityContactSyncFragment.java */
/* renamed from: com.sec.chaton.settings.x */
/* loaded from: classes.dex */
class C2836x implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityContactSyncFragment f10379a;

    C2836x(ActivityContactSyncFragment activityContactSyncFragment) {
        this.f10379a = activityContactSyncFragment;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (this.f10379a.getView() != null) {
            this.f10379a.getListView().invalidateViews();
            if (C1493a.m6463a("support_contact_auto_sync")) {
                preference.setSummary(this.f10379a.m8955b());
                return false;
            }
            preference.setSummary(this.f10379a.m8956c());
            return false;
        }
        return false;
    }
}
