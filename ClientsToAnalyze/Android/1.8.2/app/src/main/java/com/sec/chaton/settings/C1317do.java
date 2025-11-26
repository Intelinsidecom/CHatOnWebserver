package com.sec.chaton.settings;

import android.preference.Preference;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.do */
/* loaded from: classes.dex */
class C1317do implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f4892a;

    private C1317do(SettingFragment settingFragment) {
        this.f4892a = settingFragment;
    }

    /* synthetic */ C1317do(SettingFragment settingFragment, C1308df c1308df) {
        this(settingFragment);
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f4892a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, (Fragment) this.f4892a.f4731c.get(preference.getKey()), "container").commit();
        this.f4892a.getActivity().findViewById(R.id.base_divider).setVisibility(0);
        return true;
    }
}
