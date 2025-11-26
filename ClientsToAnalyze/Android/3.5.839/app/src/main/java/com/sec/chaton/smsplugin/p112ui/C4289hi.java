package com.sec.chaton.smsplugin.p112ui;

import android.preference.Preference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.sec.chaton.R;
import com.sec.chaton.util.C4809aa;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: SMSPreferenceActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hi */
/* loaded from: classes.dex */
class C4289hi implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ SMSPreferenceActivity f15672a;

    C4289hi(SMSPreferenceActivity sMSPreferenceActivity) {
        this.f15672a = sMSPreferenceActivity;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str = obj + "";
        if (obj != null && str.equals("true")) {
            if (this.f15672a.f15087h != null) {
                this.f15672a.f15081b.addPreference(this.f15672a.f15087h);
            }
            if (!C4809aa.m18104a().m18119a("free_sms_show_dialog", (Boolean) false).booleanValue()) {
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f15672a);
                abstractC4932aM18733a.mo18740a(this.f15672a.getString(R.string.freesms_use));
                abstractC4932aM18733a.mo18742a(true);
                View viewInflate = ((LayoutInflater) this.f15672a.getSystemService("layout_inflater")).inflate(R.layout.layout_using_freesms_popup, (ViewGroup) null);
                CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.isShowPopup);
                checkBox.setText(R.string.ams_never_show_again);
                checkBox.setVisibility(0);
                abstractC4932aM18733a.mo18748b(viewInflate);
                abstractC4932aM18733a.mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4291hk(this, checkBox)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC4290hj(this));
                abstractC4932aM18733a.mo18745a();
                abstractC4932aM18733a.mo18752b();
            }
            C4809aa.m18104a().m18125b("pref_key_is_free_sms_enable", (Boolean) true);
        } else if (obj != null && str.equals("false")) {
            if (this.f15672a.f15087h != null) {
                this.f15672a.f15081b.removePreference(this.f15672a.f15087h);
            }
            C4809aa.m18104a().m18125b("pref_key_is_free_sms_enable", (Boolean) false);
        }
        return true;
    }
}
