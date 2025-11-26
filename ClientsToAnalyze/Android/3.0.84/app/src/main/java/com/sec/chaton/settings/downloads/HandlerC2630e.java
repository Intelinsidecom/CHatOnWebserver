package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.settings.downloads.p056a.C2510a;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;

/* compiled from: AmsItemBackgroundDetail.java */
/* renamed from: com.sec.chaton.settings.downloads.e */
/* loaded from: classes.dex */
class HandlerC2630e extends Handler {

    /* renamed from: a */
    final /* synthetic */ AmsItemBackgroundDetail f9873a;

    HandlerC2630e(AmsItemBackgroundDetail amsItemBackgroundDetail) {
        this.f9873a = amsItemBackgroundDetail;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2510a c2510a = (C2510a) message.obj;
        switch (message.what) {
            case 1:
            case 2:
                if (C3250y.f11734b) {
                    C3250y.m11450b(C3364o.m11849a("PackageId: ", c2510a.m9454c(), ". Status: ", Integer.valueOf(message.what)), AmsItemBackgroundDetail.f9413b);
                }
                this.f9873a.m9270a(this.f9873a.f9426n);
                break;
            case 3:
            case 4:
                this.f9873a.f9424l = null;
                this.f9873a.m9270a(this.f9873a.f9426n);
                if (this.f9873a.f9415c != null && !this.f9873a.f9415c.isFinishing()) {
                    this.f9873a.f9415c.finish();
                    break;
                }
                break;
            case 5:
                this.f9873a.m9270a(this.f9873a.f9426n);
                break;
        }
    }
}
