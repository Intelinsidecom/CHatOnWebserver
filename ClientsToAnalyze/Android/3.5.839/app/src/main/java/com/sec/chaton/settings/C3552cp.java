package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.util.C4904y;

/* compiled from: ActivityPasswordLockView.java */
/* renamed from: com.sec.chaton.settings.cp */
/* loaded from: classes.dex */
class C3552cp implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockView f13041a;

    C3552cp(ActivityPasswordLockView activityPasswordLockView) {
        this.f13041a = activityPasswordLockView;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C4904y.m18639b("passwordLock passwordHint", this.f13041a.f12614a);
        C4904y.m18639b("now password state : " + this.f13041a.f12620g[this.f13041a.f12619f], this.f13041a.f12614a);
        this.f13041a.startActivity(new Intent(this.f13041a, (Class<?>) ActivityPasswordLockHint.class));
        return false;
    }
}
