package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.settings.downloads.p056a.C2514e;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;

/* compiled from: AniconPackageAdapter.java */
/* renamed from: com.sec.chaton.settings.downloads.ae */
/* loaded from: classes.dex */
class HandlerC2538ae extends Handler {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC2537ad f9678a;

    HandlerC2538ae(ViewOnClickListenerC2537ad viewOnClickListenerC2537ad) {
        this.f9678a = viewOnClickListenerC2537ad;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2514e c2514e = (C2514e) message.obj;
        C2539af c2539af = (C2539af) this.f9678a.f9674f.get(c2514e.m9454c());
        if (c2539af != null) {
            switch (message.what) {
                case 1:
                case 2:
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("PackageId: ", c2514e.m9454c(), ". Status: ", Integer.valueOf(message.what)), ViewOnClickListenerC2537ad.f9669b);
                    }
                    this.f9678a.notifyDataSetChanged();
                    break;
                case 3:
                case 4:
                case 5:
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("PackageId: ", c2514e.m9454c(), ". Status: ", Integer.valueOf(message.what)), ViewOnClickListenerC2537ad.f9669b);
                    }
                    this.f9678a.notifyDataSetChanged();
                    break;
                case 6:
                    c2539af.f9685g.setProgress(c2514e.m11747g().intValue());
                    break;
            }
        }
    }
}
