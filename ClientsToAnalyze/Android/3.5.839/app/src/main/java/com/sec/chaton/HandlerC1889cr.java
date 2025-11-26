package com.sec.chaton;

import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.util.C4904y;

/* compiled from: SplashActivity.java */
/* renamed from: com.sec.chaton.cr */
/* loaded from: classes.dex */
class HandlerC1889cr extends Handler {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f7106a;

    HandlerC1889cr(SplashActivity splashActivity) {
        this.f7106a = splashActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws PackageManager.NameNotFoundException {
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 150:
                if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mGldHandler getGLDFeaturePolicy Success", SplashActivity.f2006p);
                    }
                } else if (C4904y.f17872b) {
                    C4904y.m18639b("mGldHandler getGLDFeaturePolicy Fail >>> Set to default(false)", SplashActivity.f2006p);
                }
                if (C2349a.m10301a("sms_feature")) {
                    C3847e.m14665aP();
                }
                C3892o.m15036j();
                this.f7106a.m2992b(this.f7106a.m2988j());
                break;
        }
    }
}
