package com.sec.chaton.smsplugin.p112ui;

import android.preference.Preference;

/* compiled from: SMSPreferenceActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hg */
/* loaded from: classes.dex */
class C4287hg implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SMSPreferenceActivity f15670a;

    C4287hg(SMSPreferenceActivity sMSPreferenceActivity) {
        this.f15670a = sMSPreferenceActivity;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f15670a.f15090k.m18125b("pref_key_auto_transform_to_mms", (Boolean) false);
        } else {
            this.f15670a.f15090k.m18125b("pref_key_auto_transform_to_mms", (Boolean) true);
        }
        return true;
    }
}
