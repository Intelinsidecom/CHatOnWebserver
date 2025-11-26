package com.sec.chaton.msgbox;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.chat.C0592i;
import com.sec.chaton.p015b.p016a.C0257e;
import com.sec.chaton.p015b.p016a.EnumC0255c;
import com.sec.chaton.p018c.C0476aa;
import com.sec.chaton.trunk.database.p046a.C1173b;
import com.sec.widget.C1619g;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.r */
/* loaded from: classes.dex */
class HandlerC0753r extends Handler {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2557a;

    HandlerC0753r(MsgboxFragment msgboxFragment) {
        this.f2557a = msgboxFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f2557a.getActivity() != null) {
            C0257e c0257e = (C0257e) ((C0592i) message.obj).m2777a();
            switch (message.what) {
                case 2:
                    if (c0257e.f604a || C0520a.m2709a(message.what, c0257e.m917b()) == EnumC0255c.CHANGE_SERVER) {
                        if (!this.f2557a.f2490D.isShowing()) {
                            this.f2557a.f2490D.show();
                        }
                        this.f2557a.f2489C.m835a(this.f2557a.f2511q, this.f2557a.f2510p, this.f2557a.f2507m, (String[]) this.f2557a.f2505k.toArray(new String[0]));
                        break;
                    } else {
                        this.f2557a.f2489C.m852b(false);
                        C1619g.m5888a(this.f2557a.getActivity(), R.string.toast_end_chat_fail, 0).show();
                        C0476aa.m2436a().m2441c();
                        this.f2557a.f2489C.m853b(this.f2557a.f2495I);
                        break;
                    }
                    break;
                case 8:
                    if (this.f2557a.f2490D.isShowing()) {
                        this.f2557a.f2490D.dismiss();
                    }
                    this.f2557a.f2489C.m852b(false);
                    C0476aa.m2436a().m2441c();
                    if (c0257e.f604a || C0520a.m2709a(message.what, c0257e.m917b()) == EnumC0255c.REGARD_SUCCEESS) {
                        this.f2557a.m3153e();
                        this.f2557a.f2489C.m857f();
                        this.f2557a.f2489C.m856e();
                        try {
                            C1173b.m4237a(this.f2557a.getActivity(), C1173b.m4235a(this.f2557a.f2510p));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        C1619g.m5888a(this.f2557a.getActivity(), R.string.toast_end_chat_fail, 0).show();
                    }
                    this.f2557a.f2489C.m853b(this.f2557a.f2495I);
                    break;
            }
        }
    }
}
