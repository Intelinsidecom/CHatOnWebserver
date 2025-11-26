package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;

/* compiled from: ActivityDownloads.java */
/* renamed from: com.sec.chaton.settings.q */
/* loaded from: classes.dex */
class C1338q implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDownloads f4914a;

    C1338q(ActivityDownloads activityDownloads) {
        this.f4914a = activityDownloads;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f4914a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentDeleteAccount(), "container").addToBackStack(ActivitySettings.f4559g).commit();
        this.f4914a.getActivity().findViewById(R.id.base_divider).setVisibility(0);
        return true;
    }
}
