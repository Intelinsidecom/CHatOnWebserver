package com.sec.chaton.settings;

import android.content.SharedPreferences;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: FreeSmsInfoPreference.java */
/* renamed from: com.sec.chaton.settings.fh */
/* loaded from: classes.dex */
class SharedPreferencesOnSharedPreferenceChangeListenerC3625fh implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ FreeSmsInfoPreference f13172a;

    private SharedPreferencesOnSharedPreferenceChangeListenerC3625fh(FreeSmsInfoPreference freeSmsInfoPreference) {
        this.f13172a = freeSmsInfoPreference;
    }

    /* synthetic */ SharedPreferencesOnSharedPreferenceChangeListenerC3625fh(FreeSmsInfoPreference freeSmsInfoPreference, ViewOnClickListenerC3624fg viewOnClickListenerC3624fg) {
        this(freeSmsInfoPreference);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        C3890m.m14996b("FreeSmsInfoPreference", "FreeSMSInfo onSharedPreferenceChanged key:" + str);
        if (str.equals("free_sms_remain_count") || str.equals("free_sms_max_count") || str.equals("free_sms_invitation_count")) {
            C3890m.m14996b("FreeSmsInfoPreference", "FreeSMSInfo onSharedPreferenceChanged notifyChanged invoked");
            this.f13172a.notifyChanged();
        }
    }
}
