package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.anicon.AniconPackageListView;

/* compiled from: ActivityDownload2.java */
/* renamed from: com.sec.chaton.settings.n */
/* loaded from: classes.dex */
class C1335n implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDownload2 f4911a;

    C1335n(ActivityDownload2 activityDownload2) {
        this.f4911a = activityDownload2;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f4911a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new AniconPackageListView(), "container").addToBackStack(ActivitySettings.f4559g).commit();
        this.f4911a.getActivity().findViewById(R.id.base_divider).setVisibility(0);
        return true;
    }
}
