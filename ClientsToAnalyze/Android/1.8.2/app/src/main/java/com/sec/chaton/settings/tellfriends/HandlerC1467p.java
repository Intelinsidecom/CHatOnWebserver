package com.sec.chaton.settings.tellfriends;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/* compiled from: InviteFacebookActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.p */
/* loaded from: classes.dex */
class HandlerC1467p extends Handler {

    /* renamed from: a */
    final /* synthetic */ InviteFacebookActivity f5375a;

    HandlerC1467p(InviteFacebookActivity inviteFacebookActivity) {
        this.f5375a = inviteFacebookActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.obj.getClass().equals(ImageView.class)) {
            if (message.what >= this.f5375a.f4948d && message.what < this.f5375a.f4948d + this.f5375a.f4949e) {
                ((ImageView) message.obj).setBackgroundDrawable(((C1373ba) this.f5375a.f4957n.get(message.what)).f5205d);
            }
        } else if (message.obj.getClass().equals(String.class)) {
        }
        super.handleMessage(message);
        if (this.f5375a.f4953i > 0) {
            InviteFacebookActivity inviteFacebookActivity = this.f5375a;
            InviteFacebookActivity inviteFacebookActivity2 = this.f5375a;
            int i = inviteFacebookActivity2.f4948d;
            inviteFacebookActivity2.f4948d = i + 1;
            inviteFacebookActivity.m4794a(i);
            InviteFacebookActivity inviteFacebookActivity3 = this.f5375a;
            inviteFacebookActivity3.f4953i--;
        }
        InviteFacebookActivity inviteFacebookActivity4 = this.f5375a;
        inviteFacebookActivity4.f4952h--;
    }
}
