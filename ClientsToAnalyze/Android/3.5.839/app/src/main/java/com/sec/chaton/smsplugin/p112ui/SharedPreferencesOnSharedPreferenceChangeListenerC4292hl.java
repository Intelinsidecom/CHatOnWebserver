package com.sec.chaton.smsplugin.p112ui;

import android.content.SharedPreferences;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4904y;

/* compiled from: SMSPreferenceActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hl */
/* loaded from: classes.dex */
class SharedPreferencesOnSharedPreferenceChangeListenerC4292hl implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SMSPreferenceActivity f15676a;

    private SharedPreferencesOnSharedPreferenceChangeListenerC4292hl(SMSPreferenceActivity sMSPreferenceActivity) {
        this.f15676a = sMSPreferenceActivity;
    }

    /* synthetic */ SharedPreferencesOnSharedPreferenceChangeListenerC4292hl(SMSPreferenceActivity sMSPreferenceActivity, HandlerC4284hd handlerC4284hd) {
        this(sMSPreferenceActivity);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        C3890m.m14996b(this.f15676a.f15080a, "onSharedPreferenceChanged key:" + str);
        if (str.equals("free_sms_is_available")) {
            C3890m.m14996b(this.f15676a.f15080a, "onSharedPreferenceChanged notifyChanged invoked");
            try {
                this.f15676a.m16177a();
            } catch (Exception e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        }
    }
}
