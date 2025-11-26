package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.util.C1341p;

/* compiled from: PhoneSettingFragment.java */
/* renamed from: com.sec.chaton.settings.am */
/* loaded from: classes.dex */
class C1015am implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ PhoneSettingFragment f3617a;

    C1015am(PhoneSettingFragment phoneSettingFragment) {
        this.f3617a = phoneSettingFragment;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        C1341p.m4660c("SyncNow onPreferenceChange " + obj + ", " + this.f3617a.getView(), getClass().getSimpleName());
        if (this.f3617a.getView() != null) {
            this.f3617a.getListView().invalidateViews();
            return false;
        }
        return false;
    }
}
