package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.widget.C3641ai;

/* compiled from: AniconPackageDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.am */
/* loaded from: classes.dex */
class HandlerC2546am extends Handler {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDownloads f9692a;

    HandlerC2546am(AniconPackageDownloads aniconPackageDownloads) {
        this.f9692a = aniconPackageDownloads;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f9692a.f9480b != null && message.what == 1002) {
            C0267d c0267d = (C0267d) message.obj;
            this.f9692a.f9484f = null;
            this.f9692a.m9330e();
            if (c0267d.m1351b() != EnumC1587o.SUCCESS) {
                C3641ai.m13210a(this.f9692a.f9480b, C2555av.m9488a(R.string.dev_network_error), 1).show();
                this.f9692a.f9480b.finish();
            } else {
                this.f9692a.getLoaderManager().initLoader(0, null, this.f9692a);
                this.f9692a.f9481c.setAdapter((ListAdapter) this.f9692a.f9485g);
                this.f9692a.m9336b(true);
                this.f9692a.m9335a(true);
            }
        }
    }
}
