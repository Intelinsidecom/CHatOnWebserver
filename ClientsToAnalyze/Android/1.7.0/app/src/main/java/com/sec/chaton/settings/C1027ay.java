package com.sec.chaton.settings;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.registration.ActivityChatonVDownloads;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: PhoneSettingFragment.java */
/* renamed from: com.sec.chaton.settings.ay */
/* loaded from: classes.dex */
class C1027ay implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ PhoneSettingFragment f3628a;

    C1027ay(PhoneSettingFragment phoneSettingFragment) {
        this.f3628a = phoneSettingFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        try {
            this.f3628a.startActivity(new Intent(this.f3628a.getActivity(), (Class<?>) ActivityChatonVDownloads.class));
            return true;
        } catch (ActivityNotFoundException e) {
            C1341p.m4653a(e, getClass().getSimpleName());
            C1619g.m5889a(this.f3628a.getActivity(), "Problem is occurred!!", 0).show();
            return true;
        }
    }
}
