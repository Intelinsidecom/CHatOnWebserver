package com.sec.chaton.settings;

import android.os.Looper;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.df */
/* loaded from: classes.dex */
class C3569df implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f13058a;

    C3569df(ActivitySettings activitySettings) {
        this.f13058a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f13058a.f12659h = ProgressDialogC4926s.m18727a(CommonApplication.m18732r(), null, this.f13058a.getResources().getString(R.string.wait_sending));
        C2093az.m9337a().mo9080c(new HandlerC3570dg(this, Looper.getMainLooper()));
        return true;
    }
}
