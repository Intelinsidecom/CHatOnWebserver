package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.ca */
/* loaded from: classes.dex */
class C3537ca implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13025a;

    C3537ca(ActivityNoti2 activityNoti2) {
        this.f13025a = activityNoti2;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        AbstractC4932a.m18733a(this.f13025a).mo18734a(R.string.setting_alerts_method).mo18739a(new C3539cc(this.f13025a), this.f13025a.m13431b(this.f13025a.f12546F), this.f13025a.f12554d).mo18755c(this.f13025a.getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
        return true;
    }
}
