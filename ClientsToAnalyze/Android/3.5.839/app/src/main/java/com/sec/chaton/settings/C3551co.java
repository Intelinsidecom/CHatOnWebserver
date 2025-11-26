package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.util.C4904y;

/* compiled from: ActivityPasswordLockView.java */
/* renamed from: com.sec.chaton.settings.co */
/* loaded from: classes.dex */
class C3551co implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockView f13040a;

    C3551co(ActivityPasswordLockView activityPasswordLockView) {
        this.f13040a = activityPasswordLockView;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C4904y.m18639b("passwordLock select ok", this.f13040a.f12614a);
        C4904y.m18639b("now password state : " + this.f13040a.f12620g[this.f13040a.f12619f], this.f13040a.f12614a);
        Intent intent = new Intent(this.f13040a, (Class<?>) ActivityPasswordLockSet.class);
        intent.putExtra("MODE", "CHANGE");
        this.f13040a.startActivity(intent);
        return false;
    }
}
