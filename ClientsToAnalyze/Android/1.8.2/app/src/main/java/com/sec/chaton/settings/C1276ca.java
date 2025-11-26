package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.util.C1786r;

/* compiled from: FragmentPasswordLockView.java */
/* renamed from: com.sec.chaton.settings.ca */
/* loaded from: classes.dex */
class C1276ca implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentPasswordLockView f4823a;

    C1276ca(FragmentPasswordLockView fragmentPasswordLockView) {
        this.f4823a = fragmentPasswordLockView;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C1786r.m6061b("passwordLock select ok", this.f4823a.f4623a);
        C1786r.m6061b("now password state : " + this.f4823a.f4628f[this.f4823a.f4627e], this.f4823a.f4623a);
        Intent intent = new Intent(this.f4823a.getActivity(), (Class<?>) ActivityPasswordLockSet.class);
        intent.putExtra("MODE", "CHANGE");
        this.f4823a.startActivity(intent);
        return false;
    }
}
