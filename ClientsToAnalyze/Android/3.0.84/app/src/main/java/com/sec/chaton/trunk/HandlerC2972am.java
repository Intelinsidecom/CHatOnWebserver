package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkFullPresenter.java */
/* renamed from: com.sec.chaton.trunk.am */
/* loaded from: classes.dex */
class HandlerC2972am extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2971al f10772a;

    HandlerC2972am(C2971al c2971al) {
        this.f10772a = c2971al;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f10772a.m10415e()) {
            switch (message.what) {
                case 2:
                    if (this.f10772a.f10767p != null) {
                        this.f10772a.f10767p.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 3:
                    if (this.f10772a.f10767p != null) {
                        this.f10772a.f10767p.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 4:
                    if (this.f10772a.f10767p != null) {
                        this.f10772a.f10767p.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 901:
                    C0267d c0267d = (C0267d) message.obj;
                    if (this.f10772a.f10767p != null) {
                        this.f10772a.f10767p.handleMessage(Message.obtain(message));
                    }
                    if (c0267d.m1351b() != EnumC1587o.ERROR || c0267d.m1355f() != 86411) {
                        this.f10772a.m10451n();
                        break;
                    } else {
                        try {
                            C3044a.m10564a(this.f10772a.f10756e, C3044a.m10566b(this.f10772a.f10759h));
                            break;
                        } catch (Exception e) {
                            if (C3250y.f11737e) {
                                C3250y.m11443a(e, C2971al.f10754c);
                                return;
                            }
                            return;
                        }
                    }
                    break;
                case 905:
                    if (this.f10772a.f10767p != null) {
                        this.f10772a.f10767p.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
            }
        }
    }
}
