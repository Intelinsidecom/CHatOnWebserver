package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.settings.downloads.p056a.C2527r;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;

/* compiled from: SkinDetail.java */
/* renamed from: com.sec.chaton.settings.downloads.ca */
/* loaded from: classes.dex */
class HandlerC2588ca extends Handler {

    /* renamed from: a */
    final /* synthetic */ SkinDetail f9812a;

    HandlerC2588ca(SkinDetail skinDetail) {
        this.f9812a = skinDetail;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2527r c2527r = (C2527r) message.obj;
        switch (message.what) {
            case 1:
            case 2:
                if (C3250y.f11734b) {
                    C3250y.m11450b(C3364o.m11849a("PackageId: ", c2527r.m9454c(), ". Status: ", Integer.valueOf(message.what)), SkinDetail.f9534c);
                }
                this.f9812a.m9366a(this.f9812a.f9550q);
                break;
            case 3:
            case 4:
                this.f9812a.f9549p = null;
                this.f9812a.m9366a(this.f9812a.f9550q);
                break;
            case 5:
                this.f9812a.m9366a(this.f9812a.f9550q);
                break;
            case 6:
                this.f9812a.f9546m.setProgress(c2527r.m11747g().intValue());
                break;
        }
    }
}
