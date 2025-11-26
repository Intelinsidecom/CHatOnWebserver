package com.sec.chaton.smsplugin.p112ui;

import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.util.C4809aa;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ds */
/* loaded from: classes.dex */
class RunnableC4191ds implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15517a;

    RunnableC4191ds(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15517a = pluginComposeMessageActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!C3847e.m14654aE()) {
            this.f15517a.f14943O.setHint(R.string.type_to_compose_sms_message);
        } else {
            this.f15517a.f14943O.setHint(this.f15517a.getString(R.string.freesms_display_remain_count, new Object[]{Integer.valueOf(C4809aa.m18104a().m18120a("free_sms_remain_count", (Integer) 200).intValue())}));
        }
    }
}
