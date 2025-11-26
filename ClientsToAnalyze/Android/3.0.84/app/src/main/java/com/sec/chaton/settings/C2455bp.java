package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.util.C3250y;

/* compiled from: ActivityPasswordLockView.java */
/* renamed from: com.sec.chaton.settings.bp */
/* loaded from: classes.dex */
class C2455bp implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockView f9315a;

    C2455bp(ActivityPasswordLockView activityPasswordLockView) {
        this.f9315a = activityPasswordLockView;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C3250y.m11450b("passwordLock select ok", this.f9315a.f9052a);
        C3250y.m11450b("now password state : " + this.f9315a.f9058g[this.f9315a.f9057f], this.f9315a.f9052a);
        Intent intent = new Intent(this.f9315a, (Class<?>) ActivityPasswordLockSet.class);
        intent.putExtra("MODE", "CHANGE");
        this.f9315a.startActivity(intent);
        return false;
    }
}
