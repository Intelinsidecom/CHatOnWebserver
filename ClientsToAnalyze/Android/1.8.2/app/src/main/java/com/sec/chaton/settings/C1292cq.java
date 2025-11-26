package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: PhoneSettingFragment.java */
/* renamed from: com.sec.chaton.settings.cq */
/* loaded from: classes.dex */
class C1292cq implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ PhoneSettingFragment f4843a;

    C1292cq(PhoneSettingFragment phoneSettingFragment) {
        this.f4843a = phoneSettingFragment;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        this.f4843a.getListView().invalidateViews();
        return false;
    }
}
