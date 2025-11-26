package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.util.C3250y;

/* compiled from: ActivityContactSyncFragment.java */
/* renamed from: com.sec.chaton.settings.v */
/* loaded from: classes.dex */
class C2834v implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityContactSyncFragment f10377a;

    C2834v(ActivityContactSyncFragment activityContactSyncFragment) {
        this.f10377a = activityContactSyncFragment;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        C3250y.m11453c("SyncNow onPreferenceChange " + obj + ", " + this.f10377a.getView(), getClass().getSimpleName());
        if (this.f10377a.getView() != null) {
            this.f10377a.getListView().invalidateViews();
            String str = obj + "";
            if (obj != null && str.equals("true")) {
                this.f10377a.f8947a = true;
                this.f10377a.f8951e.m10983b("contact_sim_sync", (Boolean) true);
            } else {
                this.f10377a.f8947a = false;
                this.f10377a.f8951e.m10983b("contact_sim_sync", (Boolean) false);
            }
            this.f10377a.f8950d.setChecked(this.f10377a.f8947a);
        }
        return false;
    }
}
