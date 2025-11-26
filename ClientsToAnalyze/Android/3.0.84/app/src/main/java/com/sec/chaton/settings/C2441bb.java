package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.bb */
/* loaded from: classes.dex */
class C2441bb implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f9301a;

    C2441bb(ActivityNoti activityNoti) {
        this.f9301a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9301a.f9002g = AbstractC3271a.m11494a(this.f9301a.f9006k).mo11495a(R.string.settings_mute_alert).mo11496a(R.array.settings_mute_alert_type, this.f9301a.f9012q, this.f9301a.f9004i).mo11510b(this.f9301a.getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
        return true;
    }
}
