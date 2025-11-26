package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.trunk.database.p052a.C1584a;
import com.sec.chaton.util.C1786r;

/* compiled from: TrunkItemPresenter.java */
/* renamed from: com.sec.chaton.trunk.ah */
/* loaded from: classes.dex */
class HandlerC1522ah extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1521ag f5571a;

    HandlerC1522ah(C1521ag c1521ag) {
        this.f5571a = c1521ag;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        super.handleMessage(message);
        if (this.f5571a.m5358e()) {
            switch (message.what) {
                case 2:
                    if (this.f5571a.f5563r != null) {
                        this.f5571a.f5563r.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 3:
                    if (this.f5571a.f5563r != null) {
                        this.f5571a.f5563r.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 4:
                    if (this.f5571a.f5563r != null) {
                        this.f5571a.f5563r.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 901:
                    C0101b c0101b = (C0101b) message.obj;
                    if (this.f5571a.f5563r != null) {
                        this.f5571a.f5563r.handleMessage(Message.obtain(message));
                    }
                    if (c0101b.m665b() != EnumC0803m.ERROR) {
                        this.f5571a.m5387p();
                        break;
                    } else if (c0101b.m673f() == 86411) {
                        try {
                            C1584a.m5471a(this.f5571a.f5550e, C1584a.m5473b(this.f5571a.f5553h));
                            break;
                        } catch (Exception e) {
                            if (C1786r.f6455e) {
                                C1786r.m6056a(e, C1521ag.f5548c);
                                return;
                            }
                            return;
                        }
                    }
                    break;
                case 903:
                    if (this.f5571a.f5563r != null) {
                        this.f5571a.f5563r.handleMessage(Message.obtain(message));
                    }
                    this.f5571a.m5387p();
                    break;
                case 905:
                    if (this.f5571a.f5563r != null) {
                        this.f5571a.f5563r.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 906:
                    if (this.f5571a.f5563r != null) {
                        this.f5571a.f5563r.handleMessage(Message.obtain(message));
                    }
                    this.f5571a.m5387p();
                    break;
                case 907:
                    if (this.f5571a.f5563r != null) {
                        this.f5571a.f5563r.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
            }
        }
    }
}
