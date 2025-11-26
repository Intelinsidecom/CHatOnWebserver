package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.u */
/* loaded from: classes.dex */
class C1478u implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f5398a;

    C1478u(ActivityGeneral activityGeneral) {
        this.f5398a = activityGeneral;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f5398a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentDeleteAccount(), "container").addToBackStack(ActivitySettings.f4559g).commit();
        return true;
    }
}
