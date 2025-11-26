package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.settings.downloads.p056a.C2518i;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;

/* compiled from: FontListAdapter.java */
/* renamed from: com.sec.chaton.settings.downloads.bn */
/* loaded from: classes.dex */
class HandlerC2574bn extends Handler {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC2573bm f9764a;

    HandlerC2574bn(ViewOnClickListenerC2573bm viewOnClickListenerC2573bm) {
        this.f9764a = viewOnClickListenerC2573bm;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2518i c2518i = (C2518i) message.obj;
        C2579bs c2579bs = (C2579bs) this.f9764a.f9758f.get(c2518i.m9454c());
        if (c2579bs != null) {
            switch (message.what) {
                case 1:
                case 2:
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("PackageId: ", c2518i.m9454c(), ". Status: ", Integer.valueOf(message.what)), ViewOnClickListenerC2573bm.f9753b);
                    }
                    this.f9764a.notifyDataSetChanged();
                    break;
                case 3:
                case 4:
                case 5:
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("PackageId: ", c2518i.m9454c(), ". Status: ", Integer.valueOf(message.what)), ViewOnClickListenerC2573bm.f9753b);
                    }
                    this.f9764a.notifyDataSetChanged();
                    break;
                case 6:
                    c2579bs.f9777h.setProgress(c2518i.m11747g().intValue());
                    break;
            }
        }
    }
}
