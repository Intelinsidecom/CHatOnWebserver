package com.sec.chaton.msgbox;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.provider.p089a.C3035a;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;

/* compiled from: MsgboxSync.java */
/* renamed from: com.sec.chaton.msgbox.bv */
/* loaded from: classes.dex */
public class HandlerC2657bv extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2654bs f9523a;

    public HandlerC2657bv(C2654bs c2654bs) {
        this.f9523a = c2654bs;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = null;
        if (message.obj != null) {
            c0778b = (C0778b) message.obj;
        }
        switch (message.what) {
            case 2301:
                C4904y.m18639b("mChatListSyncHandler GetChatListInfo.GET_CHATLISTINFO", C2654bs.f9510a);
                if (c0778b == null) {
                    C4904y.m18639b("GET_CHATLISTINFO : ChatONHttpTextResponseEntry is empty. ", C2654bs.f9510a);
                    this.f9523a.m11186a(2);
                } else if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    if (this.f9523a.f9512b == 2) {
                        this.f9523a.m11186a(3);
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Fail to sync ChatListInfo ... ", C2654bs.f9510a);
                        C4904y.m18639b("ChatListInfo Fail code : " + c0778b.m3107b() + ", message : " + c0778b.m3113h(), C2654bs.f9510a);
                        C2404a.m10430a("01000006", "1008", c0778b);
                    }
                } else {
                    C4904y.m18639b("Success to sync ChatListInfo ... ", C2654bs.f9510a);
                    if (C3035a.m12470f()) {
                        C3035a.m12467e();
                        C1813b.m8906b().m8934b(C1813b.f6835d);
                    }
                    if (this.f9523a.f9512b == 2) {
                        if (!C3035a.m12464b()) {
                            C4904y.m18639b("GET_CHATLISTINFO : NO_CONTENT ", C2654bs.f9510a);
                            this.f9523a.m11186a(1);
                        } else {
                            this.f9523a.m11186a(2);
                        }
                    }
                }
                if (this.f9523a.f9512b != 1) {
                    if (this.f9523a.f9512b == 2) {
                        if (C4822an.m18226c()) {
                            this.f9523a.m11183g();
                            break;
                        } else {
                            this.f9523a.m11184h();
                            break;
                        }
                    }
                } else if (C4822an.m18226c()) {
                    this.f9523a.m11183g();
                    break;
                }
                break;
        }
    }
}
