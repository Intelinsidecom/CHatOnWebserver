package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: ActivityContactSyncFragment.java */
/* renamed from: com.sec.chaton.settings.w */
/* loaded from: classes.dex */
class C2835w implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityContactSyncFragment f10378a;

    C2835w(ActivityContactSyncFragment activityContactSyncFragment) {
        this.f10378a = activityContactSyncFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (this.f10378a.getView() != null) {
            if (!this.f10378a.f8947a) {
                this.f10378a.f8947a = true;
                this.f10378a.f8951e.m10983b("contact_sim_sync", (Boolean) true);
            } else {
                this.f10378a.f8947a = false;
                this.f10378a.f8951e.m10983b("contact_sim_sync", (Boolean) false);
            }
            this.f10378a.f8950d.setChecked(this.f10378a.f8947a);
        }
        this.f10378a.getListView().invalidateViews();
        return true;
    }
}
