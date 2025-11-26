package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import java.security.NoSuchAlgorithmException;

/* compiled from: FragmentPasswordLockView.java */
/* renamed from: com.sec.chaton.settings.bz */
/* loaded from: classes.dex */
class C1274bz implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentPasswordLockView f4821a;

    C1274bz(FragmentPasswordLockView fragmentPasswordLockView) {
        this.f4821a = fragmentPasswordLockView;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) throws NoSuchAlgorithmException {
        C1786r.m6061b("passwordLock select ok", this.f4821a.f4623a);
        C1786r.m6061b("now password state : " + this.f4821a.f4628f[this.f4821a.f4627e], this.f4821a.f4623a);
        this.f4821a.f4628f = this.f4821a.m4611a("GET", "", "");
        if (this.f4821a.f4628f[this.f4821a.f4627e].equals(C1781m.m6025c())) {
            C1786r.m6061b("LOCK_STATE changed to : OFF", this.f4821a.f4623a);
            this.f4821a.m4610a(C1781m.m6027d());
            this.f4821a.m4611a("SET", "OFF", "0000");
            return false;
        }
        this.f4821a.m4610a(C1781m.m6027d());
        C1786r.m6061b("LOCK_STATE changed to : ON", this.f4821a.f4623a);
        Intent intent = new Intent(this.f4821a.getActivity(), (Class<?>) ActivityPasswordLockSet.class);
        intent.putExtra("MODE", "SET");
        this.f4821a.startActivity(intent);
        return false;
    }
}
