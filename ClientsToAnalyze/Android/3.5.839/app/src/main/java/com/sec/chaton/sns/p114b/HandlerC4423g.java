package com.sec.chaton.sns.p114b;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.sns.p113a.C4368e;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.sns.b.g */
/* loaded from: classes.dex */
class HandlerC4423g extends Handler {

    /* renamed from: a */
    final /* synthetic */ C4374a f15978a;

    HandlerC4423g(C4374a c4374a) {
        this.f15978a = c4374a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 313:
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    C4368e.m16564a(this.f15978a.f15847c).m16565a(C4368e.f15815a, false);
                    break;
                } else {
                    C4368e.m16564a(this.f15978a.f15847c).m16565a(C4368e.f15815a, true);
                    break;
                }
                break;
        }
    }
}
