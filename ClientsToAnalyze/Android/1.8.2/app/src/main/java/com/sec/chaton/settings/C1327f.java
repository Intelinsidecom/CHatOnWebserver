package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.block.BlockFragment;

/* compiled from: ActivityBuddyView.java */
/* renamed from: com.sec.chaton.settings.f */
/* loaded from: classes.dex */
class C1327f implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityBuddyView f4903a;

    C1327f(ActivityBuddyView activityBuddyView) {
        this.f4903a = activityBuddyView;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f4903a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new BlockFragment(), "container").addToBackStack(ActivitySettings.f4559g).commit();
        return true;
    }
}
