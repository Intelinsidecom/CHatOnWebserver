package com.sec.chaton.msgbox;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1770hp;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p046a.p047a.EnumC0789m;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.r */
/* loaded from: classes.dex */
class HandlerC2673r extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2660e f9584a;

    HandlerC2673r(C2660e c2660e) {
        this.f9584a = c2660e;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f9584a.f9540d != null) {
            C0788l c0788l = (C0788l) ((C1770hp) message.obj).m8779a();
            if (c0788l == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("resultEntry is null", getClass().getSimpleName());
                    return;
                }
                return;
            }
            switch (message.what) {
                case 8:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("deleteNetworkRequest[EndChatRequest] finished", C2660e.f9537b);
                    }
                    if (this.f9584a.f9542f != null && this.f9584a.f9542f.isShowing()) {
                        this.f9584a.f9542f.dismiss();
                    }
                    this.f9584a.f9541e.m9645b(false);
                    this.f9584a.f9541e.m9267b(this.f9584a.f9552p);
                    if (c0788l.f2172a || C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.REGARD_SUCCEESS) {
                        C5179v.m19810a(this.f9584a.f9540d, R.string.trunk_toast_deleted, 0).show();
                    } else if (!this.f9584a.f9549m || c0788l.f2172a || c0788l.m3152g() != 5005) {
                        C5179v.m19810a(this.f9584a.f9540d, R.string.toast_end_chat_fail, 0).show();
                    } else {
                        this.f9584a.f9549m = false;
                        this.f9584a.m11210a(this.f9584a.f9544h, EnumC2300t.TOPIC, this.f9584a.f9545i);
                        break;
                    }
                    if (this.f9584a.f9546j == 7) {
                        this.f9584a.m11216a(c0788l.f2172a || C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.REGARD_SUCCEESS, c0788l);
                        break;
                    }
                    break;
                case 25:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("deleteNetworkRequest[AsyncEndChatRequest] finished", C2660e.f9537b);
                    }
                    this.f9584a.f9541e.m9267b(this.f9584a.f9552p);
                    this.f9584a.m11216a(c0788l.f2172a || C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.REGARD_SUCCEESS, (C0788l) null);
                    break;
            }
        }
    }
}
