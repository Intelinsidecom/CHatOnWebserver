package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.util.C4809aa;

/* compiled from: ActivityContactSyncFragment.java */
/* renamed from: com.sec.chaton.settings.aq */
/* loaded from: classes.dex */
class HandlerC3499aq extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityContactSyncFragment f12987a;

    HandlerC3499aq(ActivityContactSyncFragment activityContactSyncFragment) {
        this.f12987a = activityContactSyncFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 302 && this.f12987a.getActivity() != null) {
            if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                C4809aa.m18104a().m18128b("Setting Sync TimeInMillis", String.valueOf(System.currentTimeMillis()));
            }
            this.f12987a.f12510l.setSummary(this.f12987a.m13389e());
            this.f12987a.m60a().invalidateViews();
        }
    }
}
