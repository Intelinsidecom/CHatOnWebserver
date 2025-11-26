package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.R;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.aq */
/* loaded from: classes.dex */
class C1019aq implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f3620a;

    C1019aq(ActivityNoti activityNoti) {
        this.f3620a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3620a.startActivity(new Intent(this.f3620a, (Class<?>) SettingContainerActivity.class).putExtra("contentId", R.string.settings_type));
        return false;
    }
}
