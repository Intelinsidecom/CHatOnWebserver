package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.util.C1786r;

/* compiled from: FragmentPasswordLockView.java */
/* renamed from: com.sec.chaton.settings.cb */
/* loaded from: classes.dex */
class C1277cb implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentPasswordLockView f4824a;

    C1277cb(FragmentPasswordLockView fragmentPasswordLockView) {
        this.f4824a = fragmentPasswordLockView;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C1786r.m6061b("passwordLock passwordHint", this.f4824a.f4623a);
        C1786r.m6061b("now password state : " + this.f4824a.f4628f[this.f4824a.f4627e], this.f4824a.f4623a);
        this.f4824a.startActivity(new Intent(this.f4824a.getActivity(), (Class<?>) ActivityPasswordLockHint.class));
        return false;
    }
}
