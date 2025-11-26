package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.cw */
/* loaded from: classes.dex */
class C3559cw implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f13048a;

    C3559cw(ActivityPrivacy activityPrivacy) {
        this.f13048a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f13048a.startActivity(new Intent(this.f13048a.f12624b, (Class<?>) PostONHideActivity.class));
        return true;
    }
}
