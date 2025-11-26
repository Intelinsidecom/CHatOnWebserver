package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.util.C4904y;

/* compiled from: ActivityContactSyncFragment.java */
/* renamed from: com.sec.chaton.settings.am */
/* loaded from: classes.dex */
class C3495am implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityContactSyncFragment f12983a;

    C3495am(ActivityContactSyncFragment activityContactSyncFragment) {
        this.f12983a = activityContactSyncFragment;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        C4904y.m18641c("SyncNow onPreferenceChange " + obj + ", " + this.f12983a.getView(), getClass().getSimpleName());
        if (this.f12983a.getView() != null) {
            this.f12983a.m60a().invalidateViews();
            String str = obj + "";
            if (obj != null && str.equals("true")) {
                this.f12983a.f12507i = true;
                this.f12983a.f12512n.m18125b("contact_sim_sync", (Boolean) true);
            } else {
                this.f12983a.f12507i = false;
                this.f12983a.f12512n.m18125b("contact_sim_sync", (Boolean) false);
            }
            this.f12983a.f12511m.setChecked(this.f12983a.f12507i);
        }
        return false;
    }
}
