package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.bt */
/* loaded from: classes.dex */
class C1049bt implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f3660a;

    C1049bt(ActivityGeneral activityGeneral) {
        this.f3660a = activityGeneral;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3660a.startActivity(new Intent(this.f3660a.f3435e, (Class<?>) ActivityAbout.class));
        return true;
    }
}
