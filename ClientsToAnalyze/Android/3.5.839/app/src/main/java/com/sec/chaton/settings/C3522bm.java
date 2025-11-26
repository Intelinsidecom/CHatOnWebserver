package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.util.C4847bl;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.bm */
/* loaded from: classes.dex */
class C3522bm implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13010a;

    C3522bm(ActivityNoti2 activityNoti2) {
        this.f13010a = activityNoti2;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (!C4847bl.m18333a()) {
            this.f13010a.f12551a = AbstractC4932a.m18733a(this.f13010a).mo18734a(R.string.settings_mute_alert).mo18735a(R.array.settings_mute_alert_type, this.f13010a.f12547G, this.f13010a.f12555e).mo18755c(this.f13010a.getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
        }
        return true;
    }
}
