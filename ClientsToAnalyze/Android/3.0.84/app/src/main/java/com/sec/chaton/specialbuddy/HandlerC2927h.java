package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.mobileweb.C1692s;
import com.sec.chaton.mobileweb.EnumC1688o;
import com.sec.chaton.mobileweb.p047a.AsyncTaskC1674a;

/* compiled from: ChatONLiveEventFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.h */
/* loaded from: classes.dex */
class HandlerC2927h extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONLiveEventFragment f10458a;

    HandlerC2927h(ChatONLiveEventFragment chatONLiveEventFragment) {
        this.f10458a = chatONLiveEventFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        EnumC1688o enumC1688oM6977a;
        if (this.f10458a.m6966k() && (enumC1688oM6977a = EnumC1688o.m6977a(message.what)) != null) {
            String str = (String) message.obj;
            switch (enumC1688oM6977a) {
                case HANDSHAKE_V2:
                    new AsyncTaskC1674a(this.f10458a.f10400l, C1692s.m6987a(this.f10458a.m6962g())).execute(str);
                    break;
            }
        }
    }
}
