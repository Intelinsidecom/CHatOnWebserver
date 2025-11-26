package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.by */
/* loaded from: classes.dex */
class C3534by implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13022a;

    C3534by(ActivityNoti2 activityNoti2) {
        this.f13022a = activityNoti2;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        AbstractC4932a.m18733a(this.f13022a).mo18734a(R.string.setting_alerts_popuptype).mo18742a(true).mo18739a(new C3540cd(this.f13022a), this.f13022a.f12544D, this.f13022a.f12553c).mo18741a(this.f13022a.getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
        return true;
    }
}
