package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.widget.C3641ai;

/* compiled from: FontDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.bd */
/* loaded from: classes.dex */
class HandlerC2564bd extends Handler {

    /* renamed from: a */
    final /* synthetic */ FontDownloads f9743a;

    HandlerC2564bd(FontDownloads fontDownloads) {
        this.f9743a = fontDownloads;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f9743a.f9524c != null && message.what == 1000) {
            C0267d c0267d = (C0267d) message.obj;
            this.f9743a.f9528g = null;
            this.f9743a.m9356f();
            if (c0267d.m1351b() != EnumC1587o.SUCCESS) {
                C3641ai.m13210a(this.f9743a.f9524c, C2555av.m9488a(R.string.dev_network_error), 1).show();
                this.f9743a.f9524c.finish();
            } else {
                this.f9743a.getLoaderManager().initLoader(-1, null, this.f9743a);
                this.f9743a.m9363b(true);
                this.f9743a.m9362a(true);
            }
        }
    }
}
