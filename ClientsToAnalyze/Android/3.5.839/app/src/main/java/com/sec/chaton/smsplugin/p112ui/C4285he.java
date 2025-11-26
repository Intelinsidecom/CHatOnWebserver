package com.sec.chaton.smsplugin.p112ui;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.smsplugin.p111h.C3892o;

/* compiled from: SMSPreferenceActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.he */
/* loaded from: classes.dex */
class C4285he implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ SMSPreferenceActivity f15668a;

    C4285he(SMSPreferenceActivity sMSPreferenceActivity) {
        this.f15668a = sMSPreferenceActivity;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (C3892o.m15023b()) {
            this.f15668a.startActivityForResult(new Intent("android.settings.WIRELESS_SETTINGS"), 0);
            return true;
        }
        Intent intentM15026c = C3892o.m15026c();
        if (intentM15026c == null) {
            return false;
        }
        this.f15668a.startActivity(intentM15026c);
        C3892o.m15031e();
        return true;
    }
}
