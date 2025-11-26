package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.account.C0210g;

/* compiled from: SyncNowFragment.java */
/* renamed from: com.sec.chaton.settings.dt */
/* loaded from: classes.dex */
class C1322dt implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ SyncNowFragment f4897a;

    C1322dt(SyncNowFragment syncNowFragment) {
        this.f4897a = syncNowFragment;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C0210g.m1811a(true);
        return true;
    }
}
