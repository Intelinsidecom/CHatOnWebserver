package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.br */
/* loaded from: classes.dex */
class C1047br implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f3658a;

    C1047br(ActivityGeneral activityGeneral) {
        this.f3658a = activityGeneral;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        ActivityGeneral.m3791a((Context) this.f3658a);
        return true;
    }
}
