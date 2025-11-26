package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.ce */
/* loaded from: classes.dex */
class HandlerC1061ce extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1057ca f3706a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1061ce(C1057ca c1057ca, Looper looper) {
        super(looper);
        this.f3706a = c1057ca;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1003) {
            boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
            Preference preferenceFindPreference = this.f3706a.findPreference("pref_item_push_status");
            if (C1323bs.m4575a().getInt(C1341p.f4582f, 0) > 0) {
                preferenceFindPreference.setOnPreferenceClickListener(new C1051bv(this));
            }
            if (GlobalApplication.f2407a == null) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                C1057ca.m3942c(this.f3706a.getString(R.string.settings_push_status_available), preferenceFindPreference, this.f3706a.getResources().getColor(R.color.blue_color_021));
            } else {
                C1057ca.m3942c(this.f3706a.getString(R.string.settings_push_status_unavailable), preferenceFindPreference, this.f3706a.getResources().getColor(R.color.blue_color_021));
            }
        }
    }
}
