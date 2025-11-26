package com.sec.chaton.settings;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: PhoneSettingFragment.java */
/* renamed from: com.sec.chaton.settings.bb */
/* loaded from: classes.dex */
class C1031bb implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ PhoneSettingFragment f3635a;

    C1031bb(PhoneSettingFragment phoneSettingFragment) {
        this.f3635a = phoneSettingFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        try {
            this.f3635a.startActivity(new Intent("com.coolots.chaton.USER_SETTING"));
            return true;
        } catch (ActivityNotFoundException e) {
            C1341p.m4653a(e, getClass().getSimpleName());
            C1619g.m5889a(this.f3635a.getActivity(), "Install Coolots app first.", 0).show();
            return true;
        }
    }
}
