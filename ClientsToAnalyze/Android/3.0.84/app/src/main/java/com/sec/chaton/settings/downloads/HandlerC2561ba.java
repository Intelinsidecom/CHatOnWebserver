package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.settings.downloads.p056a.C2518i;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;

/* compiled from: FontDetail.java */
/* renamed from: com.sec.chaton.settings.downloads.ba */
/* loaded from: classes.dex */
class HandlerC2561ba extends Handler {

    /* renamed from: a */
    final /* synthetic */ FontDetail f9740a;

    HandlerC2561ba(FontDetail fontDetail) {
        this.f9740a = fontDetail;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2518i c2518i = (C2518i) message.obj;
        switch (message.what) {
            case 1:
            case 2:
                if (C3250y.f11734b) {
                    C3250y.m11450b(C3364o.m11849a("PackageId: ", c2518i.m9454c(), ". Status: ", Integer.valueOf(message.what)), FontDetail.f9490b);
                }
                this.f9740a.m9339a(this.f9740a.f9492B);
                break;
            case 3:
            case 4:
                this.f9740a.f9491A = null;
                this.f9740a.getLoaderManager().restartLoader(0, null, this.f9740a);
                this.f9740a.m9339a(this.f9740a.f9492B);
                break;
            case 5:
                this.f9740a.m9339a(this.f9740a.f9492B);
                break;
            case 6:
                this.f9740a.f9518w.setProgress(c2518i.m11747g().intValue());
                break;
        }
    }
}
