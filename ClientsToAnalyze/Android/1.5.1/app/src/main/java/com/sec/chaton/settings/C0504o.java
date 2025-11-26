package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.preference.Preference;
import com.sec.chaton.C0062R;
import com.sec.chaton.control.MemoControl;

/* renamed from: com.sec.chaton.settings.o */
/* loaded from: classes.dex */
class C0504o implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3196a;

    C0504o(ActivitySettings activitySettings) {
        this.f3196a = activitySettings;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f3196a.f3012s = new MemoControl(this.f3196a.f3016w);
        this.f3196a.f3012s.m2004a();
        this.f3196a.f3015v = ProgressDialog.show(this.f3196a.f2999f, null, this.f3196a.getResources().getString(C0062R.string.wait_sending), true);
        return true;
    }
}
