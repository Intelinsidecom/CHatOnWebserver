package com.sec.chaton.settings;

import android.os.Looper;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;

/* compiled from: ActivitySettings.java */
/* renamed from: com.sec.chaton.settings.ch */
/* loaded from: classes.dex */
class C2474ch implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f9334a;

    C2474ch(ActivitySettings activitySettings) {
        this.f9334a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f9334a.f9099h = ProgressDialogC3265l.m11489a(CommonApplication.m11493l(), null, this.f9334a.getResources().getString(R.string.wait_sending));
        C1302ao.m5594a().mo5482c(new HandlerC2475ci(this, Looper.getMainLooper()));
        return true;
    }
}
