package com.sec.chaton.settings.tellfriends;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.settings.tellfriends.common.C2785a;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.av */
/* loaded from: classes.dex */
class HandlerC2745av extends Handler {

    /* renamed from: a */
    final /* synthetic */ DialogC2741ar f10142a;

    HandlerC2745av(DialogC2741ar dialogC2741ar) {
        this.f10142a = dialogC2741ar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        switch (i) {
            case -1003:
                this.f10142a.f10132j.mo540a(new C2785a("Exceed time", i, null));
                this.f10142a.dismiss();
                break;
        }
    }
}
