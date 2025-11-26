package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.block.BlockActivity;

/* compiled from: ActivityBuddyView.java */
/* renamed from: com.sec.chaton.settings.bw */
/* loaded from: classes.dex */
class C1052bw implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityBuddyView f3663a;

    C1052bw(ActivityBuddyView activityBuddyView) {
        this.f3663a = activityBuddyView;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3663a.startActivity(new Intent(this.f3663a.f3424c, (Class<?>) BlockActivity.class));
        return true;
    }
}
