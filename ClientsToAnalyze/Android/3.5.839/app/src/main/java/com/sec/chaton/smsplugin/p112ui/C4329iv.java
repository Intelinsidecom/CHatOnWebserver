package com.sec.chaton.smsplugin.p112ui;

import android.preference.Preference;

/* compiled from: SpamSettingActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.iv */
/* loaded from: classes.dex */
class C4329iv implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SpamSettingActivity f15740a;

    C4329iv(SpamSettingActivity spamSettingActivity) {
        this.f15740a = spamSettingActivity;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f15740a.f15164a.m18125b("pref_key_spam_option_enable", (Boolean) false);
            this.f15740a.f15166c.setEnabled(false);
        } else {
            this.f15740a.f15164a.m18125b("pref_key_spam_option_enable", (Boolean) true);
            this.f15740a.f15166c.setEnabled(true);
        }
        return true;
    }
}
