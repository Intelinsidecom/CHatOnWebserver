package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.settings.FragmentWebView;
import com.sec.chaton.util.C4859bx;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.as */
/* loaded from: classes.dex */
class C3501as implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f12989a;

    C3501as(ActivityGeneral activityGeneral) {
        this.f12989a = activityGeneral;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f12989a.startActivity(C4859bx.m18371a(this.f12989a, FragmentWebView.mode.faq, (String) null));
        return true;
    }
}
