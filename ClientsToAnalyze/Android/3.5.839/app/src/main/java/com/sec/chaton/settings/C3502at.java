package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.settings.FragmentWebView;
import com.sec.chaton.util.C4859bx;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.at */
/* loaded from: classes.dex */
class C3502at implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f12990a;

    C3502at(ActivityGeneral activityGeneral) {
        this.f12990a = activityGeneral;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f12990a.startActivity(C4859bx.m18371a(this.f12990a, FragmentWebView.mode.voc, (String) null));
        return true;
    }
}
