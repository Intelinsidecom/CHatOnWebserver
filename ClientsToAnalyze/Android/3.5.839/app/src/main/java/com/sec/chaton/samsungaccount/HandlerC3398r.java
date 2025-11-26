package com.sec.chaton.samsungaccount;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4859bx;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.r */
/* loaded from: classes.dex */
class HandlerC3398r extends Handler {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12359a;

    HandlerC3398r(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12359a = abstractMultiDeviceActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f12359a.f12166t) {
            C0778b c0778b = message.obj != null ? (C0778b) message.obj : null;
            switch (message.what) {
                case 301:
                    if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f12359a.m13085a(EnumC3328ag.get_buddies, c0778b != null ? c0778b.m3112g() : "");
                        break;
                    } else {
                        this.f12359a.mo13144m();
                        break;
                    }
                    break;
                case 305:
                    if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f12359a.m13085a(EnumC3328ag.extra_info, c0778b != null ? c0778b.m3112g() : "");
                        break;
                    } else {
                        this.f12359a.m13093b(this.f12359a.getResources().getString(R.string.auto_regi_buddy_sync));
                        if (!this.f12359a.f12163q) {
                            this.f12359a.f12122N.m9495a();
                            break;
                        } else {
                            C2186al.m9763a();
                            this.f12359a.f12122N.m9495a();
                            this.f12359a.f12122N.m9515c();
                            break;
                        }
                    }
                case 411:
                    if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f12359a.m13085a(EnumC3328ag.get_profile_all, c0778b != null ? c0778b.m3112g() : "");
                        break;
                    } else if (C4859bx.m18369a(this.f12359a.f12118J, this.f12359a.f12142ah) != 0) {
                        this.f12359a.m13093b(this.f12359a.getResources().getString(R.string.auto_regi_buddy_sync));
                        C2186al.m9763a();
                        this.f12359a.f12122N.m9495a();
                        this.f12359a.f12122N.m9515c();
                        break;
                    }
                    break;
                case 2301:
                    this.f12359a.m13148q();
                    if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f12359a.m13085a(EnumC3328ag.get_chatlist, c0778b != null ? c0778b.m3112g() : "");
                        break;
                    } else {
                        this.f12359a.mo13144m();
                        C2134o.m9567a(null);
                        break;
                    }
                    break;
                case 11101:
                    if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f12359a.m13085a(EnumC3328ag.check_notification, c0778b != null ? c0778b.m3112g() : "");
                        break;
                    } else {
                        this.f12359a.m13109f(true);
                        break;
                    }
            }
        }
    }
}
