package com.sec.chaton.settings;

import android.preference.Preference;
import java.io.IOException;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.bb */
/* loaded from: classes.dex */
class C1250bb implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f4791a;

    C1250bb(ActivitySettings activitySettings) {
        this.f4791a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) throws IOException {
        C1305dc.m4753a(this.f4791a.getActivity());
        return true;
    }
}
