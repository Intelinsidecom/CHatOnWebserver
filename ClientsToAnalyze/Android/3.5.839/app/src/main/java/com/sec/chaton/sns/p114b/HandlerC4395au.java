package com.sec.chaton.sns.p114b;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.sns.p113a.C4368e;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.sns.b.au */
/* loaded from: classes.dex */
class HandlerC4395au extends Handler {

    /* renamed from: a */
    final /* synthetic */ C4394at f15926a;

    HandlerC4395au(C4394at c4394at) {
        this.f15926a = c4394at;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 313:
                C0778b c0778b = (C0778b) message.obj;
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    C4368e.m16564a(this.f15926a.f15830a).m16565a(C4368e.f15816b, true);
                    break;
                } else {
                    C4368e.m16564a(this.f15926a.f15830a).m16565a(C4368e.f15816b, false);
                    break;
                }
                break;
            case 12005:
                this.f15926a.m16708c((String) message.obj);
                break;
        }
    }
}
