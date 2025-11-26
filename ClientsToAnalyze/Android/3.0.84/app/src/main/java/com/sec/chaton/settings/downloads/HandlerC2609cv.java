package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.settings.downloads.p056a.C2531v;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;

/* compiled from: SoundDetail.java */
/* renamed from: com.sec.chaton.settings.downloads.cv */
/* loaded from: classes.dex */
class HandlerC2609cv extends Handler {

    /* renamed from: a */
    final /* synthetic */ SoundDetail f9834a;

    HandlerC2609cv(SoundDetail soundDetail) {
        this.f9834a = soundDetail;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2531v c2531v = (C2531v) message.obj;
        switch (message.what) {
            case 1:
            case 2:
                if (C3250y.f11734b) {
                    C3250y.m11450b(C3364o.m11849a("PackageId: ", c2531v.m9454c(), ". Status: ", Integer.valueOf(message.what)), SoundDetail.f9569c);
                }
                this.f9834a.m9390a(this.f9834a.f9587s);
                break;
            case 3:
            case 4:
                this.f9834a.f9586r = null;
                this.f9834a.getLoaderManager().restartLoader(0, null, this.f9834a);
                this.f9834a.m9390a(this.f9834a.f9587s);
                break;
            case 5:
                this.f9834a.m9390a(this.f9834a.f9587s);
                break;
            case 6:
                this.f9834a.f9584p.setProgress(c2531v.m11747g().intValue());
                break;
        }
    }
}
