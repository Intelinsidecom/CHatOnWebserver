package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;

/* compiled from: ActivityBuddyView.java */
/* renamed from: com.sec.chaton.settings.g */
/* loaded from: classes.dex */
class C1328g implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityBuddyView f4904a;

    C1328g(ActivityBuddyView activityBuddyView) {
        this.f4904a = activityBuddyView;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f4904a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SuggestionsActivity(), "container").addToBackStack(ActivitySettings.f4559g).commit();
        return true;
    }
}
