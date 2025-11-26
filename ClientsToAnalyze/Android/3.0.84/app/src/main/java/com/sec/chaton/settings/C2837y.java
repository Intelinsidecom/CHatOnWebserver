package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.account.C0423i;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: ActivityContactSyncFragment.java */
/* renamed from: com.sec.chaton.settings.y */
/* loaded from: classes.dex */
class C2837y implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityContactSyncFragment f10380a;

    C2837y(ActivityContactSyncFragment activityContactSyncFragment) {
        this.f10380a = activityContactSyncFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f10380a.getActivity(), R.string.trunk_network_not_available, 0).show();
        } else {
            C0423i.m3039a(true);
        }
        return false;
    }
}
