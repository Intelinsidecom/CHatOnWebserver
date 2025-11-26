package com.sec.chaton.settings;

import android.preference.Preference;
import java.io.IOException;

/* compiled from: PhoneSettingFragment.java */
/* renamed from: com.sec.chaton.settings.cr */
/* loaded from: classes.dex */
class C1293cr implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ PhoneSettingFragment f4844a;

    C1293cr(PhoneSettingFragment phoneSettingFragment) {
        this.f4844a = phoneSettingFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) throws IOException {
        C1305dc.m4753a(this.f4844a.getActivity());
        return true;
    }
}
