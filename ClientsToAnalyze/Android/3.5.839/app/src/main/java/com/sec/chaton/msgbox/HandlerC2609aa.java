package com.sec.chaton.msgbox;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.aa */
/* loaded from: classes.dex */
class HandlerC2609aa extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2681z f9427a;

    HandlerC2609aa(C2681z c2681z) {
        this.f9427a = c2681z;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 3:
                if (C4904y.f17872b) {
                    C4904y.m18639b("[SMS]DELETE_SMS_SUCCESS", C2660e.f9537b);
                }
                this.f9427a.f9610a.f9550n = true;
                break;
        }
        if (this.f9427a.f9612c == null || this.f9427a.f9612c.size() <= 0) {
            this.f9427a.f9610a.m11216a(true, (C0788l) null);
        } else if (this.f9427a.f9612c.size() == 1 && !TextUtils.isEmpty(this.f9427a.f9613d)) {
            this.f9427a.f9610a.f9549m = true;
            this.f9427a.f9610a.f9544h = (String) this.f9427a.f9612c.get(0);
            this.f9427a.f9610a.f9545i = this.f9427a.f9613d;
            this.f9427a.f9610a.m11210a(this.f9427a.f9610a.f9544h, this.f9427a.f9611b, this.f9427a.f9610a.f9545i);
        } else {
            this.f9427a.f9610a.m11213a((ArrayList<String>) this.f9427a.f9612c, this.f9427a.f9611b);
        }
        C1813b.m8906b().m8934b(C1813b.f6835d);
        super.handleMessage(message);
    }
}
