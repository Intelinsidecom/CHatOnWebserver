package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.settings.downloads.p056a.C2510a;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;

/* compiled from: AmsItemAdapter.java */
/* renamed from: com.sec.chaton.settings.downloads.b */
/* loaded from: classes.dex */
class HandlerC2560b extends Handler {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC2509a f9739a;

    HandlerC2560b(ViewOnClickListenerC2509a viewOnClickListenerC2509a) {
        this.f9739a = viewOnClickListenerC2509a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2510a c2510a = (C2510a) message.obj;
        C2587c c2587c = (C2587c) this.f9739a.f9608f.get(c2510a.m9454c());
        if (c2587c != null) {
            switch (message.what) {
                case 1:
                case 2:
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("PackageId: ", c2510a.m9454c(), ". Status: ", Integer.valueOf(message.what)), ViewOnClickListenerC2509a.f9603b);
                    }
                    this.f9739a.notifyDataSetChanged();
                    break;
                case 3:
                case 4:
                case 5:
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("PackageId: ", c2510a.m9454c(), ". Status: ", Integer.valueOf(message.what)), ViewOnClickListenerC2509a.f9603b);
                    }
                    this.f9739a.notifyDataSetChanged();
                    break;
                case 6:
                    c2587c.f9809e.setProgress(c2510a.m11747g().intValue());
                    break;
            }
        }
    }
}
