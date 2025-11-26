package com.sec.chaton.samsungaccount;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.t */
/* loaded from: classes.dex */
class HandlerC3400t extends Handler {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12361a;

    HandlerC3400t(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12361a = abstractMultiDeviceActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        if (!this.f12361a.f12166t) {
            C0778b c0778b = (C0778b) message.obj;
            if (message.what == 1104) {
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    this.f12361a.m13085a(EnumC3328ag.version_for_nation, c0778b != null ? c0778b.m3112g() : "");
                    return;
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("GET_VERSION_NOTICE success", getClass().getSimpleName());
                }
                if (C4859bx.m18386a(this.f12361a.f12118J)) {
                    this.f12361a.m13093b(this.f12361a.getResources().getString(R.string.synchronising_chatonv));
                    if (this.f12361a.f12142ah != null) {
                        this.f12361a.f12148an.m9312c(null);
                        return;
                    }
                    this.f12361a.m13093b(this.f12361a.getResources().getString(R.string.auto_regi_buddy_sync));
                    C2186al.m9763a();
                    this.f12361a.f12122N.m9495a();
                    this.f12361a.f12122N.m9515c();
                    return;
                }
                this.f12361a.m13093b(this.f12361a.getResources().getString(R.string.auto_regi_buddy_sync));
                C2186al.m9763a();
                this.f12361a.f12122N.m9495a();
                this.f12361a.f12122N.m9515c();
            }
        }
    }
}
