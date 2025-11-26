package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.util.C3241p;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.by */
/* loaded from: classes.dex */
class C2464by implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f9324a;

    C2464by(ActivityPrivacy activityPrivacy) {
        this.f9324a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (this.f9324a.f9083u[this.f9324a.f9084v].equals(C3241p.m11408d())) {
            Intent intent = new Intent(this.f9324a, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "PRIVACY");
            this.f9324a.startActivity(intent);
            return false;
        }
        this.f9324a.startActivity(new Intent(this.f9324a, (Class<?>) ActivityPasswordLockView.class));
        return false;
    }
}
