package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.anicon.AniconPackageListView;

/* compiled from: ActivityDownloads.java */
/* renamed from: com.sec.chaton.settings.r */
/* loaded from: classes.dex */
class C1339r implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDownloads f4915a;

    C1339r(ActivityDownloads activityDownloads) {
        this.f4915a = activityDownloads;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f4915a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new AniconPackageListView(), "container").addToBackStack(ActivitySettings.f4559g).commit();
        this.f4915a.getActivity().findViewById(R.id.base_divider).setVisibility(0);
        return true;
    }
}
