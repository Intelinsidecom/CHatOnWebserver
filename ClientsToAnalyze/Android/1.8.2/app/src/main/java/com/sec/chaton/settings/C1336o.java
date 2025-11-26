package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.skin.SkinListView;

/* compiled from: ActivityDownload2.java */
/* renamed from: com.sec.chaton.settings.o */
/* loaded from: classes.dex */
class C1336o implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDownload2 f4912a;

    C1336o(ActivityDownload2 activityDownload2) {
        this.f4912a = activityDownload2;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f4912a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SkinListView(), "container").addToBackStack(ActivitySettings.f4559g).commit();
        this.f4912a.getActivity().findViewById(R.id.base_divider).setVisibility(0);
        return true;
    }
}
