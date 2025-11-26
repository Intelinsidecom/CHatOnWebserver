package com.sec.chaton.push.message.processer;

import com.sec.pns.msg.frontend.MsgFrontend;

/* renamed from: com.sec.chaton.push.message.processer.q */
/* loaded from: classes.dex */
class RunnableC0382q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MsgFrontend.NotiGroup f2716a;

    /* renamed from: b */
    final /* synthetic */ MessageController f2717b;

    RunnableC0382q(MessageController messageController, MsgFrontend.NotiGroup notiGroup) {
        this.f2717b = messageController;
        this.f2716a = notiGroup;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2717b.f2650s.m2947a(this.f2716a);
        } finally {
            this.f2717b.m2913r();
        }
    }
}
