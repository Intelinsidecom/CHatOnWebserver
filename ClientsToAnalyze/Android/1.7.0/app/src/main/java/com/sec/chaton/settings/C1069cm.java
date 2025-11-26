package com.sec.chaton.settings;

import android.preference.Preference;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.cm */
/* loaded from: classes.dex */
class C1069cm implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ C1057ca f3714a;

    C1069cm(C1057ca c1057ca) {
        this.f3714a = c1057ca;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C1057ca.m3933a(this.f3714a.getActivity());
        return true;
    }
}
