package com.sec.chaton.sns.p114b;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.sns.p113a.C4368e;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.sns.b.bj */
/* loaded from: classes.dex */
class HandlerC4411bj extends Handler {

    /* renamed from: a */
    final /* synthetic */ C4410bi f15960a;

    HandlerC4411bj(C4410bi c4410bi) {
        this.f15960a = c4410bi;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 313:
                C0778b c0778b = (C0778b) message.obj;
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    C4368e.m16564a(this.f15960a.f15830a).m16565a(C4368e.f15817c, true);
                    break;
                } else {
                    C4368e.m16564a(this.f15960a.f15830a).m16565a(C4368e.f15817c, false);
                    break;
                }
                break;
        }
    }
}
