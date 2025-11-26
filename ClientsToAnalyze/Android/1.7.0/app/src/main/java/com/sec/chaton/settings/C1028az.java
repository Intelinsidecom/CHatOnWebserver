package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: PhoneSettingFragment.java */
/* renamed from: com.sec.chaton.settings.az */
/* loaded from: classes.dex */
class C1028az implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ PhoneSettingFragment f3629a;

    C1028az(PhoneSettingFragment phoneSettingFragment) {
        this.f3629a = phoneSettingFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C1017ao.m3917a(this.f3629a.getActivity());
        return true;
    }
}
