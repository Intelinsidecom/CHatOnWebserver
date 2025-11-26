package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.util.C3250y;

/* compiled from: ActivityPasswordLockView.java */
/* renamed from: com.sec.chaton.settings.bq */
/* loaded from: classes.dex */
class C2456bq implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockView f9316a;

    C2456bq(ActivityPasswordLockView activityPasswordLockView) {
        this.f9316a = activityPasswordLockView;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C3250y.m11450b("passwordLock passwordHint", this.f9316a.f9052a);
        C3250y.m11450b("now password state : " + this.f9316a.f9058g[this.f9316a.f9057f], this.f9316a.f9052a);
        this.f9316a.startActivity(new Intent(this.f9316a, (Class<?>) ActivityPasswordLockHint.class));
        return false;
    }
}
