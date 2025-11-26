package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.settings.downloads.p056a.C2527r;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;

/* compiled from: SkinAdapter.java */
/* renamed from: com.sec.chaton.settings.downloads.bx */
/* loaded from: classes.dex */
class HandlerC2584bx extends Handler {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC2583bw f9797a;

    HandlerC2584bx(ViewOnClickListenerC2583bw viewOnClickListenerC2583bw) {
        this.f9797a = viewOnClickListenerC2583bw;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2527r c2527r = (C2527r) message.obj;
        C2586bz c2586bz = (C2586bz) this.f9797a.f9794e.get(c2527r.m9454c());
        if (c2586bz != null) {
            switch (message.what) {
                case 1:
                case 2:
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("download_skin, PackageId: ", c2527r.m9454c(), ". Status: ", Integer.valueOf(message.what)), ViewOnClickListenerC2583bw.f9790b);
                    }
                    this.f9797a.notifyDataSetChanged();
                    break;
                case 3:
                case 4:
                case 5:
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("download_skin, PackageId: ", c2527r.m9454c(), ". Status: ", Integer.valueOf(message.what)), ViewOnClickListenerC2583bw.f9790b);
                    }
                    this.f9797a.notifyDataSetChanged();
                    break;
                case 6:
                    c2586bz.f9802e.setProgress(c2527r.m11747g().intValue());
                    break;
            }
        }
    }
}
