package com.sec.chaton.settings.tellfriends;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p022h.EnumC0803m;

/* compiled from: SnsFriendsUsingChatOnActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ah */
/* loaded from: classes.dex */
class HandlerC1353ah extends Handler {

    /* renamed from: a */
    final /* synthetic */ SnsFriendsUsingChatOnActivity f5170a;

    HandlerC1353ah(SnsFriendsUsingChatOnActivity snsFriendsUsingChatOnActivity) {
        this.f5170a = snsFriendsUsingChatOnActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 313:
                if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                    this.f5170a.m4863m();
                    break;
                } else {
                    C1350ae.m5081a(this.f5170a.getApplicationContext()).m5084a(this.f5170a.f4993k, true);
                    this.f5170a.f4995m = new C0633e(this.f5170a.f4986c);
                    this.f5170a.f4995m.m2863a(this.f5170a.f4993k, this.f5170a.f4994l);
                    break;
                }
                break;
        }
    }
}
