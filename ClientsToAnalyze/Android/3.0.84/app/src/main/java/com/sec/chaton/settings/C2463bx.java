package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.bx */
/* loaded from: classes.dex */
class C2463bx implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f9323a;

    C2463bx(ActivityPrivacy activityPrivacy) {
        this.f9323a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9323a.startActivity(new Intent(this.f9323a.f9064b, (Class<?>) PostONHideActivity.class));
        return true;
    }
}
