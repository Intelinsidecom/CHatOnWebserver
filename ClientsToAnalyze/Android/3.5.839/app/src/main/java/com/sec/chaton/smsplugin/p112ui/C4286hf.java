package com.sec.chaton.smsplugin.p112ui;

import android.preference.Preference;
import com.sec.common.util.log.collector.C5043h;

/* compiled from: SMSPreferenceActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hf */
/* loaded from: classes.dex */
class C4286hf implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SMSPreferenceActivity f15669a;

    C4286hf(SMSPreferenceActivity sMSPreferenceActivity) {
        this.f15669a = sMSPreferenceActivity;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj == null || !str.equals("true")) {
            this.f15669a.f15090k.m18125b("pref_key_using_sms_mms_mode", (Boolean) false);
            C5043h.m19179a().m19183a("0300", "2119");
            if (this.f15669a.f15084e != null) {
                this.f15669a.f15084e.setEnabled(false);
            }
            if (this.f15669a.f15085f != null) {
                this.f15669a.f15085f.setEnabled(false);
            }
            if (this.f15669a.f15088i != null) {
                this.f15669a.f15088i.setEnabled(false);
            }
            if (this.f15669a.f15086g != null) {
                this.f15669a.f15086g.setEnabled(false);
            }
            if (this.f15669a.f15087h != null) {
                this.f15669a.f15087h.setEnabled(false);
            }
        } else {
            this.f15669a.f15090k.m18125b("pref_key_using_sms_mms_mode", (Boolean) true);
            C5043h.m19179a().m19183a("0300", "2120");
            if (this.f15669a.f15084e != null) {
                this.f15669a.f15084e.setEnabled(true);
            }
            if (this.f15669a.f15085f != null) {
                this.f15669a.f15085f.setEnabled(true);
            }
            if (this.f15669a.f15088i != null) {
                this.f15669a.f15088i.setEnabled(true);
            }
            if (this.f15669a.f15086g != null) {
                this.f15669a.f15086g.setEnabled(true);
            }
            if (this.f15669a.f15087h != null) {
                this.f15669a.f15087h.setEnabled(true);
            }
        }
        return true;
    }
}
