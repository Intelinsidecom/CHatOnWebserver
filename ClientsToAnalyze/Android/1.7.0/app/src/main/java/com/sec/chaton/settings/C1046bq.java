package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityGeneral.java */
/* renamed from: com.sec.chaton.settings.bq */
/* loaded from: classes.dex */
class C1046bq implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityGeneral f3657a;

    C1046bq(ActivityGeneral activityGeneral) {
        this.f3657a = activityGeneral;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3657a.startActivity(new Intent(this.f3657a.f3435e, (Class<?>) ActivityDeleteAccount.class));
        return true;
    }
}
