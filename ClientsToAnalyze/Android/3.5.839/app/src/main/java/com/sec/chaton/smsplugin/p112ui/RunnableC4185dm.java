package com.sec.chaton.smsplugin.p112ui;

import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.util.C4809aa;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dm */
/* loaded from: classes.dex */
class RunnableC4185dm implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f15509a;

    /* renamed from: b */
    final /* synthetic */ PluginComposeMessageActivity f15510b;

    RunnableC4185dm(PluginComposeMessageActivity pluginComposeMessageActivity, boolean z) {
        this.f15510b = pluginComposeMessageActivity;
        this.f15509a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f15509a && C3847e.m14654aE()) {
            this.f15510b.m15869A();
            this.f15510b.f14943O.setHint((CharSequence) null);
        } else if (!C3847e.m14654aE()) {
            this.f15510b.f14943O.setHint(R.string.type_to_compose_sms_message);
        } else {
            this.f15510b.f14943O.setHint(this.f15510b.getString(R.string.freesms_display_remain_count, new Object[]{Integer.valueOf(C4809aa.m18104a().m18120a("free_sms_remain_count", (Integer) 200).intValue())}));
        }
        this.f15510b.m16074f(this.f15509a);
        this.f15510b.m15988ac();
    }
}
