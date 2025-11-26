package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityContactSyncFragment.java */
/* renamed from: com.sec.chaton.settings.an */
/* loaded from: classes.dex */
class C3496an implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityContactSyncFragment f12984a;

    C3496an(ActivityContactSyncFragment activityContactSyncFragment) {
        this.f12984a = activityContactSyncFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (this.f12984a.getView() != null) {
            if (!this.f12984a.f12507i) {
                this.f12984a.f12507i = true;
                this.f12984a.f12512n.m18125b("contact_sim_sync", (Boolean) true);
            } else {
                this.f12984a.f12507i = false;
                this.f12984a.f12512n.m18125b("contact_sim_sync", (Boolean) false);
            }
            this.f12984a.f12511m.setChecked(this.f12984a.f12507i);
        }
        this.f12984a.m60a().invalidateViews();
        return true;
    }
}
