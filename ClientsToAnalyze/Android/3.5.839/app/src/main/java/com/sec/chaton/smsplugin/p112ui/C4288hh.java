package com.sec.chaton.smsplugin.p112ui;

import android.preference.Preference;

/* compiled from: SMSPreferenceActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hh */
/* loaded from: classes.dex */
class C4288hh implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SMSPreferenceActivity f15671a;

    C4288hh(SMSPreferenceActivity sMSPreferenceActivity) {
        this.f15671a = sMSPreferenceActivity;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f15671a.f15090k.m18125b("pref_key_vibrate_on_switching_to_mms", (Boolean) false);
        } else {
            this.f15671a.f15090k.m18125b("pref_key_vibrate_on_switching_to_mms", (Boolean) true);
        }
        return true;
    }
}
