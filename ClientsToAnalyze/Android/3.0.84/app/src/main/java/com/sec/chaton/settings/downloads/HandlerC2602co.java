package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.widget.C3641ai;

/* compiled from: SkinListView.java */
/* renamed from: com.sec.chaton.settings.downloads.co */
/* loaded from: classes.dex */
class HandlerC2602co extends Handler {

    /* renamed from: a */
    final /* synthetic */ SkinListView f9829a;

    HandlerC2602co(SkinListView skinListView) {
        this.f9829a = skinListView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f9829a.f9558b != null && message.what == 1100) {
            this.f9829a.f9563g = null;
            this.f9829a.m9382d();
            if (((C0267d) message.obj).m1351b() != EnumC1587o.SUCCESS) {
                C3641ai.m13210a(this.f9829a.f9558b, C2555av.m9488a(R.string.dev_network_error), 1).show();
                this.f9829a.f9558b.finish();
            } else {
                this.f9829a.m9387a(true);
                this.f9829a.getLoaderManager().initLoader(0, null, this.f9829a);
            }
        }
    }
}
