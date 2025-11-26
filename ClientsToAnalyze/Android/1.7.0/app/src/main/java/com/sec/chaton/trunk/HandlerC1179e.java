package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.trunk.database.p046a.C1173b;
import com.sec.chaton.util.C1341p;

/* compiled from: TrunkItemPresenter.java */
/* renamed from: com.sec.chaton.trunk.e */
/* loaded from: classes.dex */
class HandlerC1179e extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1104ab f4045a;

    HandlerC1179e(C1104ab c1104ab) {
        this.f4045a = c1104ab;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4045a.m4179j()) {
            switch (message.what) {
                case 2:
                    if (this.f4045a.f3876r != null) {
                        this.f4045a.f3876r.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 3:
                    if (this.f4045a.f3876r != null) {
                        this.f4045a.f3876r.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 4:
                    if (this.f4045a.f3876r != null) {
                        this.f4045a.f3876r.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 901:
                    C0259g c0259g = (C0259g) message.obj;
                    if (this.f4045a.f3876r != null) {
                        this.f4045a.f3876r.handleMessage(Message.obtain(message));
                    }
                    if (c0259g.m928b() != EnumC0518y.ERROR || c0259g.m934f() != 86411) {
                        this.f4045a.m4116p();
                        break;
                    } else {
                        try {
                            C1173b.m4237a(this.f4045a.f3863e, C1173b.m4239b(this.f4045a.f3866h));
                            break;
                        } catch (Exception e) {
                            if (C1341p.f4581e) {
                                C1341p.m4653a(e, C1104ab.f3861c);
                                return;
                            }
                            return;
                        }
                    }
                    break;
                case 903:
                    if (this.f4045a.f3876r != null) {
                        this.f4045a.f3876r.handleMessage(Message.obtain(message));
                    }
                    this.f4045a.m4116p();
                    break;
                case 905:
                    if (this.f4045a.f3876r != null) {
                        this.f4045a.f3876r.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 906:
                    if (this.f4045a.f3876r != null) {
                        this.f4045a.f3876r.handleMessage(Message.obtain(message));
                    }
                    this.f4045a.m4116p();
                    break;
                case 907:
                    if (this.f4045a.f3876r != null) {
                        this.f4045a.f3876r.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
            }
        }
    }
}
