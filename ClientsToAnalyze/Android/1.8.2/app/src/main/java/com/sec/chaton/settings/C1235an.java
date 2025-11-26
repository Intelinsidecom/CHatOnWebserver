package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.an */
/* loaded from: classes.dex */
class C1235an implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f4776a;

    C1235an(ActivityPrivacy activityPrivacy) {
        this.f4776a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f4776a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new RelationHideFragment(), "container").addToBackStack(ActivitySettings.f4559g).commit();
        return true;
    }
}
