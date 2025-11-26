package com.sec.chaton.settings.tellfriends;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.settings.tellfriends.common.C2785a;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bp */
/* loaded from: classes.dex */
class HandlerC2766bp extends Handler {

    /* renamed from: a */
    final /* synthetic */ DialogC2762bl f10190a;

    HandlerC2766bp(DialogC2762bl dialogC2762bl) {
        this.f10190a = dialogC2762bl;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        switch (i) {
            case -1003:
                this.f10190a.f10179k.mo540a(new C2785a("Exceed time", i, null));
                this.f10190a.dismiss();
                break;
        }
    }
}
