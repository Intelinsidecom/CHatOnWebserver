package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* compiled from: ActivityPasswordLockView.java */
/* renamed from: com.sec.chaton.settings.bo */
/* loaded from: classes.dex */
class C2454bo implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockView f9314a;

    C2454bo(ActivityPasswordLockView activityPasswordLockView) {
        this.f9314a = activityPasswordLockView;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C3250y.m11450b("passwordLock select ok", this.f9314a.f9052a);
        C3250y.m11450b("now password state : " + this.f9314a.f9058g[this.f9314a.f9057f], this.f9314a.f9052a);
        this.f9314a.f9058g = this.f9314a.m9037a("GET", "", "");
        if (this.f9314a.f9058g[this.f9314a.f9057f].equals(C3241p.m11408d())) {
            C3250y.m11450b("LOCK_STATE : " + this.f9314a.f9053b, this.f9314a.f9052a);
            this.f9314a.m9036a(C3241p.m11409e());
            this.f9314a.m9037a("SET", "OFF", "0000");
            return false;
        }
        this.f9314a.m9036a(C3241p.m11409e());
        C3250y.m11450b("LOCK_STATE : " + this.f9314a.f9053b, this.f9314a.f9052a);
        Intent intent = new Intent(this.f9314a, (Class<?>) ActivityPasswordLockSet.class);
        intent.putExtra("MODE", "SET");
        this.f9314a.startActivity(intent);
        return false;
    }
}
