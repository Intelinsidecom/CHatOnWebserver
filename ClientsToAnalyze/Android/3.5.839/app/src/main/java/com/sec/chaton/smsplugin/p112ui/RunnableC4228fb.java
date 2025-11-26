package com.sec.chaton.smsplugin.p112ui;

import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3789h;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fb */
/* loaded from: classes.dex */
class RunnableC4228fb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3782a f15580a;

    /* renamed from: b */
    final /* synthetic */ PluginComposeMessageActivity f15581b;

    RunnableC4228fb(PluginComposeMessageActivity pluginComposeMessageActivity, C3782a c3782a) {
        this.f15581b = pluginComposeMessageActivity;
        this.f15580a = c3782a;
    }

    @Override // java.lang.Runnable
    public void run() {
        C3789h c3789hM16107v = null;
        if (this.f15581b.m15878E()) {
            if (this.f15581b.m16111x()) {
                c3789hM16107v = this.f15581b.f14954Z.m16168a(false);
            }
        } else {
            c3789hM16107v = this.f15581b.m16107v();
        }
        PluginComposeMessageActivity.m16048c("[CMA] onUpdate contact updated: " + this.f15580a);
        PluginComposeMessageActivity.m16048c("[CMA] onUpdate recipients: " + c3789hM16107v);
        if (c3789hM16107v != null) {
            this.f15581b.m16109w();
            if (!this.f15581b.m15977aD()) {
                new C4264gk(this.f15581b, this.f15581b.f15048by, c3789hM16107v).start();
            }
            this.f15581b.f15050p.notifyDataSetChanged();
            if (this.f15581b.f14954Z != null) {
                this.f15581b.f14954Z.m16169a(c3789hM16107v);
            }
        }
    }
}
