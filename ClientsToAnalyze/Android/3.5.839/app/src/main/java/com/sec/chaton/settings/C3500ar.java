package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.settings.FragmentWebView;
import com.sec.chaton.util.C4859bx;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.ar */
/* loaded from: classes.dex */
class C3500ar implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f12988a;

    C3500ar(ActivityGeneral activityGeneral) {
        this.f12988a = activityGeneral;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f12988a.startActivity(C4859bx.m18371a(this.f12988a, FragmentWebView.mode.question, (String) null));
        return true;
    }
}
