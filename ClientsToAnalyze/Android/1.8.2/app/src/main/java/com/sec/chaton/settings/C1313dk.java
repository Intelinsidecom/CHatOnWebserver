package com.sec.chaton.settings;

import android.preference.Preference;
import java.io.IOException;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.dk */
/* loaded from: classes.dex */
class C1313dk implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f4888a;

    C1313dk(SettingFragment settingFragment) {
        this.f4888a = settingFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) throws IOException {
        C1305dc.m4753a(this.f4888a.getActivity());
        return true;
    }
}
