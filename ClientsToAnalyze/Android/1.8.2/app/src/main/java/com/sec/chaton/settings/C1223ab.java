package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.ab */
/* loaded from: classes.dex */
class C1223ab implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f4762a;

    C1223ab(ActivityNoti activityNoti) {
        this.f4762a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        boolean unused = ActivityNoti.f4494p = true;
        this.f4762a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentAlertTypeView2(), "container").addToBackStack(ActivitySettings.f4559g).commit();
        return true;
    }
}
