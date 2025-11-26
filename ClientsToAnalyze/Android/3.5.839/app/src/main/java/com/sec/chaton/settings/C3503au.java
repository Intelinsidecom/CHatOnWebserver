package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.samsungaccount.MainActivity;

/* compiled from: ActivityManageAccounts.java */
/* renamed from: com.sec.chaton.settings.au */
/* loaded from: classes.dex */
class C3503au implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityManageAccounts f12991a;

    C3503au(ActivityManageAccounts activityManageAccounts) {
        this.f12991a = activityManageAccounts;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = new Intent(this.f12991a.f12526i, (Class<?>) MainActivity.class);
        intent.putExtra("is_mapping_mode", true);
        this.f12991a.startActivityForResult(intent, 1);
        return false;
    }
}
