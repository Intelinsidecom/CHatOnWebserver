package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.block.BlockActivity;

/* renamed from: com.sec.chaton.settings.r */
/* loaded from: classes.dex */
class C0507r implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3199a;

    C0507r(ActivitySettings activitySettings) {
        this.f3199a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3199a.startActivity(new Intent(this.f3199a.f2999f, (Class<?>) BlockActivity.class));
        return true;
    }
}
